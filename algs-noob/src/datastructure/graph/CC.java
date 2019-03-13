package datastructure.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 测试图的连通性，使用深度优先搜索
 * @analysis: 检查是否为断开的多个图组成
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-04 11:00
 **/
public class CC {
    private boolean[] marked;
    //和顶点 v 相连的 id
    private int[] id;
    //每部分的大小
    private int[] size;
    //由几部分组成
    private int count;

    /**
     * @description: 基于无向图的构造器
     */
    public CC(Graph g) {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        size = new int[g.V()];
        for (int v = 0; v < g.V(); v++) {
            if (!marked[v]) {
                //完成几次深度优先搜索代表有几个模块
                dfs(g, v);
                count++;
            }
        }
    }

    /**
     * @description: 深度优先搜索的方法主体，比基本的多模块统计
     * @param: Graph g,int v
     */
    public void dfs(Graph g, int v) {
        marked[v] = true;
        //顶点索引数组，v 属于第 i 个连通分量，id 的值就是 i
        id[v] = count;
        for (int w : g.adj(v)) {
            //此处应该判断 w 是否探索过，也就是给定顶点的邻居
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    /**
     * @description: 判断两个点是否连通
     * @param: int w，int v
     * @return: boolean
     */
    public boolean connected(int w, int v) {
        return id[w] == id[v];
    }

    /**
     * @description: 判断顶点属于哪个连通分量
     * @param: int v
     * @return: int id
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * @description: 返回连通分量的个数
     */
    public int count() {
        return count;
    }

    /**
     * @description: 测试
     */
    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        CC cc = new CC(g);
        //连通分量的个数
        int M = cc.count();
        StdOut.println(M + " components");
        Queue<Integer>[] components = new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Queue<>();
        }
        for (int v = 0; v < g.V(); v++) {
            components[cc.id(v)].enqueue(v);
        }
        //打印结果
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

    }
}
