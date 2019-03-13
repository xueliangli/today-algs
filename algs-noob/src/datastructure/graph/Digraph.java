package datastructure.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 基于链表实现的有向图
 * @analysis: 比无向图明显的区别是 reverse 方法返回图的反向图
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-05 11:17
 **/
//TODO:添加功能:入度，出度，深拷贝;邻接矩阵表示有向图
public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    //图中顶点的个数
    private final int V;
    //边的个数
    private int E;
    //顶点 v 的邻接顶点，使用背包加数组的数据结构构成邻接表,父链接类型的树
    private Bag<Integer>[] adj;
    //可省略，存放入度的数组
    private int[] inDegree;

    /**
     * @param V 顶点数
     * @description: 构造方法
     */
    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non negative");
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        //初始化顶点
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }

    }

    /**
     * @description: 按照特定格式的输入流初始化有向图
     */
    public Digraph(In in) {
        this.V = in.readInt();
        inDegree = new int[V];
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
        //初始化边
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    /**
     * @description: 添加顶点 w 与 顶点 v 之间的边，v 指向 w
     */
    public void addEdge(int v, int w) {
        validateVertex(w);
        validateVertex(v);
        adj[v].add(w);
        inDegree[w]++;
        E++;
    }

    /**
     * @description: 判断输入的顶点是否合法
     */
    public void validateVertex(int v) {
        if (v < 0 || v > V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    /**
     * @description: 返回顶点数
     */
    public int V() {
        return V;
    }

    /**
     * @description: 返回边数
     */
    public int E() {
        return E;
    }

    /**
     * @description: 返回顶点 v 邻接表
     */
    public Iterable<Integer> agj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * @description: 转换成字符串输出
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices ").append(E).append(" edges ").append(NEWLINE);
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                //此处 w 又疏忽写成 v 了
                sb.append(String.format("%d ", w));
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    /**
     * @description: 返回图的反向图
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    /**
     * @description: 测试
     */
    public static void main(String[] args) {
        Digraph digraph = new Digraph(new In(args[0]));
        StdOut.println(digraph);
    }
}
