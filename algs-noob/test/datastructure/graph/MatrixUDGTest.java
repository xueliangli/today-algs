package datastructure.graph;

import org.junit.Test;

public class MatrixUDGTest {
    @Test
    public void testMatrixUDG(){
            char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
            char[][] edges = new char[][]{
                    {'A', 'C'},
                    {'A', 'D'},
                    {'A', 'F'},
                    {'B', 'C'},
                    {'C', 'D'},
                    {'E', 'G'},
                    {'F', 'G'}};
            MatrixUDG pG;

            // 采用已有的"图"
            pG = new MatrixUDG(vexs, edges);

            pG.print();   // 打印图
    }
    //FIXME : 死循环，李学亮，2018/12/26，
    /**
     * 在主函数中进行测试就可以运行
     *
     * 出错原因：
     * 读取的程序有问题，需要在 linux 系统上运行
     * */
    @Test
    public void testMatrixUDG1(){
        //自定义"图"(输入矩阵队列)
        MatrixUDG matrixUDG = new MatrixUDG();
        matrixUDG.print();   // 打印图
    }
}
