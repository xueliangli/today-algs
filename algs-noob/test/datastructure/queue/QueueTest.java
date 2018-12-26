package datastructure.queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
/**
 * 关于队列的测试
 */
public class QueueTest {
    @Test
    public void testMyQueue() {
        Queue<Integer> ints = new Queue<>();
        for (int i = 0; i < 10; i++) {
            ints.enqueue(i);
        }
        ints.displayList();
    }
    /**
     * 出错原因：
     * 算法第四版上的程序需要在 linux 系统上运行
     * */
    @Test
    public void testQueue1(){
            Queue<String> q = new Queue<>();
            while (!StdIn.isEmpty()) {
                String item = StdIn.readString();
                if (!item.equals("-")) q.enqueue(item);
                else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
            }
            StdOut.println("(" + q.size() + " left on queue)");
    }
}
