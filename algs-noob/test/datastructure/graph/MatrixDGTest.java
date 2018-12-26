package datastructure.graph;

import org.junit.Test;

public class MatrixDGTest {
    @Test
    public void testMatrixDG(){
            char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
            char[][] edges = new char[][]{
                    {'A', 'B'},
                    {'B', 'C'},
                    {'B', 'E'},
                    {'B', 'F'},
                    {'C', 'E'},
                    {'D', 'C'},
                    {'E', 'B'},
                    {'E', 'D'},
                    {'F', 'G'}};
            MatrixDG pG;

            // 自定义"图"(输入矩阵队列)
            //pG = new MatrixDG();
            // 采用已有的"图"
            pG = new MatrixDG(vexs, edges);

            pG.print();   // 打印图
            pG.DFS();     // 深度优先遍历
            pG.BFS();     // 广度优先遍历

    }
}
