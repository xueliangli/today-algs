

import edu.princeton.cs.algs4.In;

import java.util.Iterator;


/*************************************************************************
 *
 * 基于链表的栈的一种基本实现：
 *
 * 下压堆栈
 *
 * 参照算法第四版 : P94
 *
 *************************************************************************/


public class Stack<Item> implements Iterable<Item> {

    private int N;          //栈的容量
    private Node first;     //栈顶

    /**
     * 内部类，构造节点的数据结构
     */
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * 构造一个空栈
     */
    private Stack() {
        first = null;
        N = 0;
    }

    /**
     * 判断栈是否为空
     */
    private boolean isEmpty() {
        return first == null;
    }

    /**
     * 返回栈中元素的个数
     */
    private int size() {
        return N;
    }

    /**
     * 入栈操作
     */
    private void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * 出栈操作
     */
    private Item pop() {
        if (isEmpty())
            throw new RuntimeException("Stack underflow");
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }


    /**
     * 迭代器功能的实现，实现迭代器的接口，重写其中的 iterator 方法
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * 实现的是 Iterator 接口，不要与 Iterable 接口搞混
     */
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * test
     */
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        String[] items = In.readStrings("tobe.txt");
        for (String item : items) {
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
                System.out.print(s.pop() + " ");
        }
        System.out.println();
        System.out.println("( " + s.size() + " left on stack)");

    }

}
