package datastructure.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
//能够foreach
    //TODO:未测试
public class Queue<Item> implements Iterable<Item> {
    /**
     * @description: 数据结构的雏形
     * @param:
     * @return:
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 21:46
     */
    private int N;
    private Node<Item> first;
    private Node<Item> last;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    /**
     * @description: 简单常用方法，是否为空，长度，峰值
     * @param: []
     * @return: boolean
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 21:48
     */
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * @description: 入队操作
     * @param: [item]
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 21:52
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    /**
     * @description: 出队操作
     * @param: []
     * @return: Item 返回删除的值
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 21:56
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        N--;
        //避免垃圾
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    /**
     * @description: 将队列转换成字符串
     * @param: []
     * @return: java.lang.String
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 21:57
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this) {
            sb.append(item);
            sb.append(' ');
        }
        return sb.toString();
    }

    /**
     * @description: 返回一个迭代器
     * @param: []
     * @return: java.util.Iterator<Item>
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 22:01
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
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
}
