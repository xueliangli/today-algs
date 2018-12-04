import edu.princeton.cs.algs4.In;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    private FixedCapacityStack(int capacity){
        a=(Item[]) new Object[capacity];
    }

    private boolean isEmpty(){
        return N==0;
    }

    private void push(Item item){
        a[N++]=item;
    }

    private Item pop(){
        return a[--N];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<Item>{

        private int i=N-1;

        @Override
        public boolean hasNext() {
            return i>=0;
        }

        //先进后出的类型
        @Override
        public Item next() {
            return a[i--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * output :
     * to be not that or be
     * Left on stack: is to
     *
     * */
    public static void main(String[] args) {
        String[] items = In.readStrings("tobe.txt");
        int max=items.length;
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(max);
        for (String item:items) {
            if (!item.equals("-")) stack.push(item);
            else if (stack.isEmpty()) StdOut.println("BAD INPUT");
            else StdOut.print(stack.pop() + " ");
        }
        StdOut.println();
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
