package datastructure.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 无向图中是否有环，基于深度优先搜索
 * @analysis: 普通环，排除平行边，自环的情况
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-04 14:34
 **/
public class Cycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    /**
     * @description: 构造器，在里面判断是否有自环和平行边
     */
    public Cycle(Graph g) {

    }

    /**
     * @param g
     * @return boolean
     * @description: 自环的判断方法
     */
    public boolean hasSelfLoop(Graph g) {
        for (int v = 0; v < g.V(); v++) {
            for (int w : g.adj(v)) {
                if (w == v) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param g
     * @return boolean
     * @description: 平行边的判断方法
     */
    public boolean hasParallelEdge(Graph g) {
        marked = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            //检查与 v 相连有没有平行边
            for (int w : g.adj(v)) {
                if (marked[w]) {
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                marked[w] = true;
            }
            //将谈搜过的顶点重新置为否
            for (int w : g.adj(v)) {
                marked[w] = false;
            }
        }
        return false;
    }

    /**
     * @description: 普通环的判断方法
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * @description: 如果有环则返回环
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }

    /**
     * @description: 深度优先搜索对保存环的栈进行操作
     * @param: 无向图，顶点 u，顶点 v
     * @return:
     * @throws:
     */
    private void dfs(Graph g, int u, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            //最短环是否找到,找到直接退出循环
            if (cycle != null) {
                return;
            }
            //如果 w 未标记
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, v, w);
            }
            //如果 w 已标记
            else if (w != v) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    /**
     * @description: 测试
     */
    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        Cycle finder = new Cycle(g);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        } else {
            StdOut.println("Graph is a cyclic");
        }

    }
}
