package datastructure.graph;

import org.junit.Test;

public class ListUDGTest {
    @Test
    public void testListUDG(){
            char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
            char[][] edges = new char[][]{
                    {'A', 'C'},
                    {'A', 'D'},
                    {'A', 'F'},
                    {'B', 'C'},
                    {'C', 'D'},
                    {'E', 'G'},
                    {'F', 'G'}};
            ListUDG pG;

            // 自定义"图"(输入矩阵队列)
            //pG = new ListUDG();
            // 采用已有的"图"
            pG = new ListUDG(vexs, edges);

            pG.print();   // 打印图
            pG.DFS();     // 深度优先遍历
            pG.BFS();     // 广度优先遍历
    }
}
