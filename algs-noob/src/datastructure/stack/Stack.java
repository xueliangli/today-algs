package datastructure.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 *
 * 基于链表,栈的一种基本实现：
 *
 * 迭代器功能待补充！！！！！！！！！
 *
 * 下压堆栈
 * 设计思路：
 * 1、成员变量：元素个数、头指针
 * 2、基于链表，所以需要 node 节点类：数据、指向下一个节点
 * 3、用于初始化的构造方法
 * 4、入队操作,出栈操作都是对头指针进行操作
 *
 *
 *************************************************************************/
public class Stack<Item> {
    private int N;
    private Node first;

    private class Node {
        private Item data;
        private Node next;
    }

    Stack() {
        first = null;
        N = 0;
    }

    boolean isEmpty() {
        return first == null;
    }

    int size() {
        return N;
    }

    void push(Item data) {
        Node cur = new Node();
        cur.next = first;
        cur.data = data;
        first = cur;
        N++;
    }

    Item pop() {
        if (isEmpty())
            System.out.println("the list is empty...");
        Item data = first.data;
        first = first.next;
        N--;
        return data;
    }
}
