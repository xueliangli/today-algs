package datastructure.first.linkedlist;

import java.util.Iterator;

/**
 * @program: algs-noob
 * @description: 单向链表
 * @analysis: 参考与算法第四版
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-12 10:39
 **/
public class SingleLink<Item> implements Iterable {
    //定义头结点
    private Node first;
    //定义链表中结点的个数
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
    public SingleLink() {
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

    /**
     * @description: 从头结点处插入
     */
    public void insertFirst(Item item) {
        Node cur = new Node();
        cur.item = item;
        cur.next = first;
        first = cur;
        N++;
    }

    /**
     * @description: 从头结点处删除
     */
    public void deleteFirst() {
        first = first.next;
        N--;
    }

    /**
     * @description: 删除指定位置处的结点 ,使用两个引用
     */
    public void deleteNode(Item item) {
        //当前的结点
        Node curNode = first;
        //删除的是头结点
        if (curNode.item == item) {
            deleteFirst();
        }
        for (int i = 0; i < N - 1; i++) {
            //当前结点的下一个结点
            Node nextNode = curNode.next;
            if (nextNode.item == item) {
                //跳过这一结点
                curNode.next = nextNode.next;
                N--;
            } else {
                curNode = curNode.next;
            }
        }
    }

    /**
     * @description: 迭代器实现
     */
    @Override
    public Iterator iterator() {
        return null;
    }
}
