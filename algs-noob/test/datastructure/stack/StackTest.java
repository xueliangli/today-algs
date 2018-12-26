package datastructure.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class StackTest {
    @Test
    public void testStack(){
            Stack<String> s = new Stack<>();
            while (!StdIn.isEmpty()) {
                String item = StdIn.readString();
                if (!item.equals("-")) s.push(item);
                else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
            }
            StdOut.println("(" + s.size() + " left on stack)");

    }
}
