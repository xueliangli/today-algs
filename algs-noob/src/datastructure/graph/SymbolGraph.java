package datastructure.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 基于符号表
 * @analysis: 健为字符串，值为整数
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-04 15:15
 **/
public class SymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Graph graph;

    /**
     * @description: 构造器, 最重要的部分
     * @param: 名字，分隔符
     * @return:
     * @throws:
     */
    public SymbolGraph(String fileName, String delimiter) {
        st = new ST<>();
        //将字符串与索引联系
        In in = new In(fileName);
        while (!in.isEmpty()) {
            String[] a = in.readLine().split(delimiter);
            for (String anA : a) {
                if (!st.contains(anA)) {
                    st.put(anA, st.size());
                }
            }
        }
        //从索引得到字符串
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }
        //双路建造从顶点到每一行的图
        graph = new Graph(st.size());
        in = new In(fileName);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                graph.addEdge(v, w);
            }
        }
    }

    /**
     * @description: 是否包含顶点
     */
    public boolean contains(String s) {
        return st.contains(s);
    }

    /**
     * @description: 相应定点的索引
     */
    public int indexOf(String s) {
        return st.get(s);
    }

    /**
     * @description: 返回对应索引顶点的名字
     */
    public String nameOf(int v) {
        validateVertex(v);
        //健是存放在数组中的
        return keys[v];
    }

    /**
     * @description: 返回图
     */
    public Graph graph() {
        return graph;
    }

    /**
     * @description: 相当于断言，含有对应的顶点则继续
     */
    private void validateVertex(int v) {
        int V = graph.V();
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    /**
     * @description: 测试
     */
    public static void main(String[] args) {
        String fileName = args[0];
        String delimiter = args[1];
        SymbolGraph sg = new SymbolGraph(fileName, delimiter);
        Graph graph = sg.graph();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            if (sg.contains(source)) {
                int s = sg.indexOf(source);
                for (int v : graph.adj(s)) {
                    StdOut.println("  " + sg.nameOf(v));
                }
            } else {
                StdOut.println(" input not contain '" + source + "' ");
            }
        }
    }
}
