package code.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: algs-noob
 * @description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @analysis: 两种方法：使用递归和使用栈
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-02-20 20:33
 * todo:不能得出正确结果
 **/
public class Solution03 {
    /**
     * @description: 定义链表的内部类
     * @param: []
     * @return:
     * @author: 李学亮
     * @date: 2019/2/20
     * @time: 20:35
     */
    public static class ListNode {
        private ListNode first;
        int val;
        ListNode next = null;

        //有参构造
        public ListNode(int val) {
            first=null;
            this.val = val;
        }

        public ListNode() {
        }
        //头插法插入新节点
        void insertFirst(int val){
            ListNode cur=new ListNode();
            cur.next=first;
            cur.val=val;
            first=cur;
        }
        //展示链表中的内容
        void displayList() {
            ListNode cur = first;
            while (cur != null) {
                System.out.print("\t" + cur.val + "->");
                cur = cur.next;
            }
        }
    }

    /**
     * @description: 使用递归方法，注意递归的停止条件
     * @param: []
     * @return:
     * @author: 李学亮
     * @date: 2019/2/20
     * @time: 20:59
     */
    ArrayList<Integer> arrayList = new ArrayList<>();

    public  ArrayList<Integer> print(ListNode listNode) {
        if (listNode != null) {
            print(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * @description: 使用迭代方法，利用栈的后进先出的特点
     * @param: []
     * @return:
     * @author: 李学亮
     * @date: 2019/2/20
     * @time: 21:00
     */
    public ArrayList<Integer> print02(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * @description: 单元测试
     */
    public static void main(String[] args) {
        ListNode listNode=new ListNode();
        for (int i = 0; i < 10; i++) {
            listNode.insertFirst(i);
        }
        listNode.displayList();
        System.out.println();
        Solution03 solution03 = new Solution03();
        for (int i = 0; i < 10; i++) {
            System.out.println(solution03.print(listNode).get(i));
        }
    }
}
/* @tips : ~
 * 链表的最后一个节点为 null
 *
 * 栈有判断是否为空的方法
 *
 * 打印出来的数字都是 0
 *
 */
