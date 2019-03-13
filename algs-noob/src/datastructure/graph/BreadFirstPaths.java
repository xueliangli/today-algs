package datastructure.graph;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @program: algs-noob
 * @description: 广度优先搜索所找图中的路径
 * @analysis: 使用队列获取下一个顶点
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-03 10:50
 **/
public class BreadFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    /**
     * @description: 构造器
     * @param: 图，起点
     */
    public BreadFirstPaths(Graph g, int s) {
        this.s = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        bfs(g, s);
    }

    /**
     * @description: 广度优先搜索的方法主体
     * @param: 图，起点
     */
    public void bfs(Graph g, int s) {
        //用一个队列存放顶点
        Queue<Integer> queue = new Queue<>();
        //将起点标记
        marked[s] = true;
        //起点入队列
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            //删去刚刚入队列的点,并搜索它的邻居
            int v = queue.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    //保存最后一条边
                    edgeTo[w] = v;
                    //标记为已探索
                    marked[w] = true;
                    //加入队列
                    queue.enqueue(w);
                }
            }
        }
    }

    /**
     * @description: 是否存在从 s 到 v 的路径
     * @param: v
     * @return: boolean
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * @description: 返回 s 到 v 的路径，不存在就返回 null
     * @param: v
     * @return: Iterator path
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        //由于 edgeTo 的数据结构不同，与深度优先搜索的区别也在这，相当于父链接表示的树
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
     * @throws:
     */
    public static void main(String[] args) {
        Graph g = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        BreadFirstPaths bfsPath = new BreadFirstPaths(g, s);
        for (int v = 0; v < g.V(); v++) {
            StdOut.print(s + " to " + v + " : ");
            //如果 s 与 v 连通，则输出路径
            if (bfsPath.hasPathTo(v)) {
                for (int w : bfsPath.pathTo(v)) {
                    if (w == s) {
                        StdOut.print(w);
                    } else {
                        StdOut.print("-" + w);
                    }
                }
            }
            StdOut.println();
        }
    }
}
