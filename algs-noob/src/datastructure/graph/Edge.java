package datastructure.graph;

import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 带权重的边，基于链表
 * @analysis: 组成加权无向图的基本结构
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-08 09:42
 **/
public class Edge implements Comparable<Edge> {
    //其中的一个顶点
    private final int v;
    //另一个顶点
    private final int w;
    //权重
    private final double weight;

    /**
     * @description: 构造方法对类进行初始化
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * @description: 返回权重的方法
     */
    public double weight() {
        return weight;
    }

    /**
     * @description: 返回其中一条顶点
     */
    public int either() {
        return v;
    }

    /**
     * @description: 返回另一个顶点
     */
    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else {
            throw new RuntimeException("Inconsisitent edge");
        }
    }

    /**
     * @description: 将对象转换成字符串输出
     */
    public String toString() {
        return String.format("%d-%d %2f", v, w, weight);
    }

    /**
     * @description: 重写比较的方法
     */
    @Override
    public int compareTo(Edge that) {
        return 0;
    }

    /**
     * @description: 测试
     */
    public static void main(String[] args) {
        Edge e = new Edge(12, 23, 2.3);
        StdOut.println(e);
    }
}
