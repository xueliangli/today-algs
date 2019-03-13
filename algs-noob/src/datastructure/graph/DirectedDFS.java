package datastructure.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 基于深度优先搜索的可达性判断
 * @analysis: 从单个一个顶点可以到达哪些顶点
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-05 20:10
 **/
//TODO:查找路径的实现
public class DirectedDFS {
    private boolean[] marked;

    /**
     * @description: 构造方法的主方法
     * @param: 有向图，一个顶点
     */
    public DirectedDFS(Digraph g, int s) {
        //创建一个存放标记的数组
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    /**
     * @description: 重载构造方法，多个顶点作为起点的实现
     * @param: 有向图，一个可迭代的数据结构
     */
    public DirectedDFS(Digraph g, Iterable<Integer> sources) {
        marked = new boolean[g.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(g, s);
            }
        }
    }

    /**
     * @description: 深度优先搜索
     */
    private void dfs(Digraph g, int v) {
        marked[v] = true;
        for (int w : g.agj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**
     * @description: 判断顶点 v 是否标记过
     */
    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        //接收输入的有向图
        Digraph g = new Digraph(new In(args[0]));
        //接收输入的多个源点
        Bag<Integer> sources = new Bag<>();
        for (int i = 1; i < args.length; i++) {
            sources.add(Integer.parseInt(args[i]));
        }
        //因为要使用判断可达性的类的服务，需要对其进行实例化
        DirectedDFS reachable = new DirectedDFS(g, sources);
        for (int v = 0; v < g.V(); v++) {
            if (reachable.marked(v)) {
                StdOut.print(v + " ");
            }
        }
        StdOut.println();
    }
}
