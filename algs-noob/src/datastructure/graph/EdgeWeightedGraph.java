package datastructure.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 加权无向图的数据类型
 * @analysis: 基于普通的图数据类型进行改造
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-08 10:56
 **/
//TODO：deep copy 有什么用处
public class EdgeWeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    //邻接表，存的是边的信息,与普通图的区别
    private Bag<Edge>[] adj;

    /**
     * @description: 构造方法
     */
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    /**
     * @description: 通过一个输入流对图进行初始化
     */
    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            double weight = in.readDouble();
            //创建一个带权重的边
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    /**
     * @description: 判断输入的顶点是否合法
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    /**
     * @description: 将创创建的边加入到图中
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /**
     * @description: 返回边数
     */
    public int E() {
        return E;
    }

    /**
     * @description: 返回顶点数
     */
    public int V() {
        return V;
    }

    /**
     * @description: 返回顶点度数
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * @description: 返回顶点的邻接表
     */
    public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * @description: 返回所有的边
     */
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    list.add(e);
                } else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                        list.add(e);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }

    /**
     * @description: 将对象转换成字符串, 重写 toString 方法，输出时直接输出字符串
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V).append(" ").append(E).append(NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v).append(" : ");
            for (Edge e : adj[v]) {
                s.append(e).append(" ");
            }
            s.append(NEWLINE);
        }
        //StringBuilder 类最后都有这一步
        return s.toString();
    }

    /**
     * @description: 测试
     */
    public static void main(String[] args) {
        EdgeWeightedGraph g = new EdgeWeightedGraph(new In(args[0]));
        StdOut.println(g);
    }
}
