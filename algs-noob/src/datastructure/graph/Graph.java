package datastructure.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 利用邻接表创建无向图
 * @analysis: 要求：为各种类型的图留出空间，实例方法的实现要快。
 * 三种表示方法：1、邻接矩阵，空间占用大 2、边的数组，求相邻顶点慢 3、邻接表
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-01 10:50
 **/
public class Graph {
    //顶点的数目
    private final int V;
    //边的数目
    private int E;
    //邻接表，用背包数据结构实现（背包，只能进不能出，不可删除元素，用来查找）
    private Bag<Integer>[] adj;

    /**
     * @description: Graph（）由顶点索引的整型链表数组
     * @param: V
     */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        //初始化链表为空,背包数据结构加入到数组中
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    /**
     * @description: Graph（）从输入流中读取 V E ,添加一条边
     * @param: In
     */
    public Graph(In in) {
        //读取V
        this(in.readInt());
        //读取 E
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    /**
     * @description:addEdge() 两个顶点互相添加链表中，边数加一
     * @param: v w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * @description: V（）返回顶点数
     */
    public int V() {
        return V;
    }

    /**
     * @description: E（）返回边数
     */
    public int E() {
        return E;
    }

    /**
     * @description: 返回与 v 相邻的顶点
     * @param: v
     * @return: Iterable 邻接链表
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * @description: toString() 转化成字符串输出,重写该方法
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V).append(" vertices, ").append(E).append(" edges ").append(NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    /**
     * @description: 测试
     */
    public static void main(String[] args) {
        //第一个参数
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}
