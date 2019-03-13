package datastructure.first.linkedlist;

import java.util.Iterator;

/**
 * @program: algs-noob
 * @description: 双向链表
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-13 13:02
 **/
//todo:可以扩展成双向循环链表
public class DoubleLink<Item> implements Iterable {
    /////////////////////////////////////////////////////////////
    //@mod: 基础
    /////////////////////////////////////////////////////////////
    private Node first;
    public int N;

    /**
     * @description: 定义结点的内部类
     */
    private class Node {
        Node prev;
        Node next;
        Item item;
    }

    /**
     * @description: 构造器
     */
    public DoubleLink() {
        first = null;
        N = 0;
    }

    private int size() {
        return N;
    }

    private boolean isEmpty() {
        return first == null;
    }

    /**
     * @description: 获取第 index 位置处的结点
     */
    //todo:通过反向查找和正向查找进行优化
    private Node getNode(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("索引不合法");
        }
        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    /**
         * @description: 获得第 index 位置处的值
         */
    public Item getItem(int index){
        return getNode(index).item;
    }
    public Item getFirst(){
        return getNode(0).item;
    }
    public Item getLast(){
        return getNode(N-1).item;
    }
    /////////////////////////////////////////////////////////////
    //@mod: 主体方法
    /////////////////////////////////////////////////////////////
    /**
         * @description: 将结点插入到第 index 之前位置
         */
    public void insert(int index){
        //插入到头结点之前
        if (index==0){

        }
    }
    /**
         * @description: 删除第 index 位置处的结点
         */
    /////////////////////////////////////////////////////////////
    //@mod: 辅助方法
    /////////////////////////////////////////////////////////////
    @Override
    public Iterator iterator() {
        return null;
    }

    /////////////////////////////////////////////////////////////
    //@mod: 测试
    /////////////////////////////////////////////////////////////
    public static void main(String[] args) {

    }
}
