import data_structure.queue.MyQueue;
import org.junit.Test;

public class DataStructure {
    @Test
    public void testMyQueue(){
        MyQueue<Integer> ints = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            ints.enqueue(i);
        }
        ints.displayList();
    }
}
