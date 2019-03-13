package datastructure.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 寻找路径，通过系统的检查每一个顶点和每一条边来获取图的性质
 * @analysis: 1、标记访问过的点 2、递归的访问未被标记的邻居点
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-02 17:06
 **/
public class DepthFirstPaths {
    private boolean[] marked;
    //一棵以父链接表示的树，能记住起点到顶点的路径，保存的是这条路径的最后一条边
    int[] edgeTo;
    private final int s;

    /**
     * @description: 构造方法
     * @param: 图，起点
     * @return:
     */
    public DepthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g, s);
    }

    /**
     * @description: 广度优先的方法主体
     * @param: 图，起点
     * @return:
     */
    public void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                //将路径当前的边保存下来
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    /**
     * @description: 和 marked（）方法相同
     * @param:
     * @return:
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * @description: 返回路径的迭代器
     * @param:
     * @return:
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    /**
     * @description: 测试
     * @param:
     * @return:
     */
    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths search = new DepthFirstPaths(g, s);
        for (int v = 0; v < g.V(); v++) {
            StdOut.print(s + " to " + v + " : ");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) {
                        StdOut.print("-" + x);
                    }else {
                        StdOut.print("-"+x);
                    }
                }
            }
            StdOut.println();
        }
    }
}
