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
public class Stack<Item> implements Iterable {
    ////////////////////////////////////////////////////////////
    //@mod: 基础
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
    public Stack() {
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
    boolean isEmpty() {
        return first == null;
    }
    ////////////////////////////////////////////////////////////
    //@mod: 主要方法
    /////////////////////////////////////////////////////////////

    /**
     * @description: 加入栈中
     */
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    /**
     * @description: 从栈中删除
     */
    public Item pop() {
        //非空判断
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    /**
     * @description: 返回栈顶元素
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        return first.item;
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
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
    }
}
