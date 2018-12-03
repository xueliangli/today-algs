import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public FixedCapacityStack(int capacity){
        a=(Item[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(Item item){
        a[N++]=item;
    }

    public Item pop(){
        return a[--N];
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
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

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStack<String> stack = new FixedCapacityStack<String>(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
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
