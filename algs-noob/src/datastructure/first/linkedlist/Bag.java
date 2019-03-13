package datastructure.first.linkedlist;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @program: algs-noob
 * @description:
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-12 11:24
 **/
public class Bag<Item> implements Iterable {
    ////////////////////////////////////////////////////////////
    //@mod: 基础,与栈唯一的区别是将 push 换成 add 去掉 pop 方法
    /////////////////////////////////////////////////////////////
    private Node first;
    private int N;

    /**
     * @description: 结点的内部类, 包含数据，下一个结点
     */
    private class Node {
        Item item;
        Node next;
    }

    /**
     * @description: 构造器
     */
    public Bag() {
        first = null;
        N = 0;
    }

    /**
     * @description: 助手，返回结点数
     */
    private int size() {
        return N;
    }

    /**
     * @description: 助手，返回是否为空链表
     */
    private boolean isEmpty() {
        return first == null;
    }
    ////////////////////////////////////////////////////////////
    //@mod: 主要方法
    /////////////////////////////////////////////////////////////

    /**
     * @description: 加入栈中
     */
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    ////////////////////////////////////////////////////////////
    //@mod: 辅助方法
    /////////////////////////////////////////////////////////////

    /**
     * @description: 转换成字符串输出
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Object item : this) {
            s.append(item);
            s.append(" ");
        }
        //调用的是重写之前的转换方法
        return s.toString();
    }

    /**
     * @description: 迭代器
     */
    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    /**
     * @description: 助手
     */
    private class ListIterator implements Iterator<Item> {
        private Node current;

        public ListIterator(Node first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    ////////////////////////////////////////////////////////////
    //@mod: 测试
    /////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (Object s : bag) {
            StdOut.println(s);
        }
    }
}
