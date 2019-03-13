package datastructure.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @program: algs-noob
 * @description: 基于链表实现栈
 * @analysis: 结点内部类，出栈，进栈，迭代器实现
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-03 10:55
 **/
public class Stack<Item> implements Iterable<Item> {
    //栈的大小
    private int n;
    //头结点,需要加泛型，不然之后方法中出现得每个都加
    private Node<Item> first;

    /**
     * @description: 结点的内部类
     */
    private static class Node<Item> {
        //值
        private Item item;
        //下一个结点
        private Node<Item> next;
    }

    /**
     * @description: 构造方法，对栈进行初始化
     */
    public Stack() {
        first = null;
        n = 0;
    }

    /**
     * @description: 进栈，对栈顶操作，也就是对头结点操作
     * @param: 进栈的值
     */
    public void push(Item item) {
        Node<Item> oldFirst = first;
        //新建一个结点
        first = new Node<>();
        first.item = item;
        //箭头的操作，新的头结点指向之前的头结点
        first.next = oldFirst;
        n++;
    }

    /**
     * @description: 入栈，对头结点操作
     * @return: 返回出栈的元素
     * @throws: 检查栈是否为空
     */
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        //保存 item 返回用
        Item item = first.item;
        //赋值操作，将头结点下一个元素赋值给头结点
        first = first.next;
        n--;
        return item;

    }

    /**
     * @description: 查看栈顶元素
     * @return: 头结点的值
     * @throws: 检查栈是否为空
     */
    public Item peek() {
        if (isEmpty()) {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    /**
     * @description: 自动生成的转换成字符串方法
     * @return: 字符串
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * @description: 实现这个接口，对象可以成为 foreach 的目标，就需要重写 iterator 方法
     * @return: 迭代器对象
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
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

    /**
     * @description: 判断是否为空
     * @return: boolean
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * @description: 判断栈的大小
     * @return: int
     */
    public int size() {
        return n;
    }
}
