package datastructure.linkedlist;

import java.util.Iterator;

/*************************************************************************
 *
 * 单向链表的简单实现
 *
 * 查找功能待补充
 *
 * 设计思路：
 * 1、成员变量：元素个数、头指针
 * 2、基于链表，所以需要 node 节点类：数据、指向下一个节点
 * 3、用于初始化的构造方法
 * 4、入队操作,出栈操作都是对头指针进行操作
 *
 *
 *************************************************************************/
public class SingleLink<Item> implements Iterable {
    //两个成员变量：节点的个数、头节点
    private int N;
    private Node first;

    //构造器对变量进行初始化
    SingleLink() {
        first = null;
        N = 0;
    }

    //通过内部类定义 node 节点：
    private class Node {
        private Item item;
        private Node next;
    }

    //返回链表长度的方法
    int size() {
        return N;
    }

    //判断链表是否为空的方法
    boolean isEmpty() {
        return first == null;
    }

    //头插法插入新节点
    void insertFirst(Item item) {
        Node cur = new Node();
        cur.next = first;
        cur.item = item;
        first = cur;
        N++;
    }

    //展示链表中的内容
    void displayList() {
        Node cur = first;
        while (cur != null) {
            System.out.print("\t" + cur.item + "->");
            cur = cur.next;
        }
    }

    //在指定位置插入节点
    //删除第一个节点
    void deleteFirst() {

        first = first.next;
        N--;
    }

    //删除指定位置的节点
    void deleteNode(Item item) {
        Node curNode = first;
        for (int i = 0; i < N - 1; i++) {
            Node nextNode = curNode.next;
            if (nextNode.item == item) {
                curNode.next = nextNode.next;
                N--;
            } else
                curNode = curNode.next;
        }
    }

    //实现迭代器遍历链表元素
    @Override
    public Iterator iterator() {
        return null;
    }
}
