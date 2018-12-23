package data_structure.queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 *
 * 基于链表,队列的一种基本实现：
 *
 * 关键点是有首尾两个指针
 *
 * 迭代器功能待补充！！！！！！！！！
 *
 * 设计思路：
 * 1、成员变量：元素个数、头指针、尾指针
 * 2、基于链表，所以需要 node 节点类：数据、指向下一个节点
 * 3、用于初始化的构造方法
 * 4、入队操作：last.next ,重点：需要先判断是不是第一个元素（1）将尾节点的下一个节点指向新节点（2）数据给新节点（3）新节点设置为尾节点（4）节点个数加 1
 * 5、出队操作：对 first 进行操作（1）判断是否为空（2）定义 data 变量接受要删除的节点数据（3）头结点设置为下一个节点（4）节点数减 1（5）返回删除的数据
 * 6、用于判断队列是否为空，返回元素个数的方法
 *************************************************************************/
public class Queue<Item> {
    private int N;
    private Node first;
    private Node last;

    private class Node {
        private Item data;
        private Node next;
    }

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private int size() {
        return N;
    }

    public void enqueue(Item data) {
        Node x = new Node();
        x.data = data;
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            last.next = x;
            last = x;
        }
        N++;
    }

    private Item dequeue() {
        if (isEmpty())
            System.out.println("the queue is empty...");
        Item data = first.data;
        first = first.next;
        N--;
        return data;
    }

    public void displayList() {
        Node cur = first;
        while (cur != null) {
            System.out.print("\t" + cur.data + "->");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
