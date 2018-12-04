import edu.princeton.cs.algs4.In;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*************************************************************************
 *
 * 基于链表实现先进先出队列
 *
 *************************************************************************/


public class Queue<Item> implements Iterable<Item>{

    private int N;
    private Node first;
    private Node last;

    /**
     * 定义节点的嵌套类
     * */
    private class Node{
        private Item item;
        private Node next;
    }

    /**
     * 空队列
     * */
    private Queue(){
        first=null;
        last=null;
        N=0;
    }

    /**
     * 入队操作
     * */
    private boolean isEmpty(){ return first==null; }
    private int size(){ return N; }

    private void enqueue(Item item){
        Node x = new Node();
        x.item=item;
        if (isEmpty()){
            first=x;
            last=x;
        }else {
            last.next=x;
            last=x;
        }
        N++;
    }

    /**
     * 出队操作
     * */
    private Item dequeue(){
        if (isEmpty())
            throw new RuntimeException("Queue underflow");
        Item item = first.item;
        first=first.next;
        N--;
        if (isEmpty())
            last=null;
        return item;
    }

    /**
     * 添加迭代器的功能
     * */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current=first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current=current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Queue<String> s = new Queue<>();
        String[] items = In.readStrings("tobe.txt");
        for (String item : items) {
            if (!item.equals("-"))
                s.enqueue(item);
            else if (!s.isEmpty())
                System.out.print(s.dequeue() + " ");
        }
        System.out.println();
        System.out.println("( " + s.size() + " left on stack)");


    }
}

