package datastructure.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

/**
 * @program: algs-noob
 * @description: 最小生成树的延时实现
 * @analysis: 不及时删除失效的边，优先队列保存横切边，有顶点作为索引的数组标记树的顶点，队列保存最小生成树的边
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-09 11:10
 **/
//TODO：结果错误
public class LazyPrimMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;

    //最小生成树的总权重
    private double weight;
    //存放最小生成树边的队列
    private Queue<Edge> mst;
    private boolean[] marked;
    //存放横切边得优先队列（包含失效的边）
    private MinPQ<Edge> pq;

    /**
     * @description: 构造器
     */
    public LazyPrimMST(EdgeWeightedGraph g) {
        pq = new MinPQ<>();
        marked = new boolean[g.V()];
        mst = new Queue<>();
        //假设 g 是连通的情况下
        visit(g, 0);
        while (!pq.isEmpty()) {
            //得到权重最小的边
            Edge e = pq.delMin();
            //得到上述边的两个顶点
            int v = e.either();
            int w = e.other(v);
            //如果两个边均在最小生成树中就是失效的边，需要跳过
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.enqueue(e);
            weight += e.weight();
            //将顶点加入到树中
            if (!marked[v]) {
                visit(g, v);
            }
            if (!marked[w]) {
                visit(g, w);
            }
        }
        assert check(g);
    }

    /**
     * @description: 标记顶点 v 并将所有连接 v 未标记的顶点的的边加入到优先队列
     */
    private void visit(EdgeWeightedGraph g, int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    /**
     * @description: 返回所有边
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * @description: 返回总权重
     */
    public double weight() {
        return weight;
    }

    /**
     * @description: 检查,权重，是否有环，是否是树，是否是最小生成树
     */
    private boolean check(EdgeWeightedGraph G) {

        // check weight
        double totalWeight = 0.0;
        for (Edge e : edges()) {
            totalWeight += e.weight();
        }
        if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
            return false;
        }

        // check that it is acyclic
        UF uf = new UF(G.V());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : G.edges()) {
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest (cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new UF(G.V());
            for (Edge f : mst) {
                int x = f.either(), y = f.other(x);
                if (f != e) uf.union(x, y);
            }

            // check that e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.either(), y = f.other(x);
                if (!uf.connected(x, y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }
        return true;
    }

    /**
     * @description: 测试
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
