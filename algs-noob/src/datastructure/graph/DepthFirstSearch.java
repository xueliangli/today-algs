package datastructure.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 探索连通性, 输出与输入定点联通的顶点
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-02 20:47
 **/
public class DepthFirstSearch {
    //探索过的顶点标记
    private boolean[] marked;
    //记录探索过的顶点数
    private int count;

    /**
     * @description: 构造方法
     * @param: 图，起点
     * @return:
     */
    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    /**
     * @description: 深度优先方法主体
     * @param: 图，起点
     * @return:
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**
     * @description: 是否连通
     * @param:
     * @return:
     */
    public boolean marked(int w) {
        return marked[w];
    }

    /**
     * @description: 计数
     * @param:
     * @return:
     */
    public int count() {
        return count;
    }

    /**
     * @description: 测试方法
     * @param:
     * @return:
     */
    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch dfs = new DepthFirstSearch(g, s);
        for (int v = 0; v < g.V(); v++) {
            if (dfs.marked(v)) {
                StdOut.print(v + " ");
            }
        }
        StdOut.println();
        if (dfs.count() != g.V()) {
            StdOut.print("not ");
        }
        StdOut.println("connected ");
    }
}
