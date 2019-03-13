package code.leetcode;

/**
 * @program: algs-noob
 * @description: Reverse Linked List
 * @analysis: 反转链表
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-01 15:13
 **/
public class First_206 {
    /**
     * @description: 链表节点的内部类
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @description: 利用递归实现
     * @param: head
     * @return: newHead
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        //注意 next 的含义，可以形象的理解成箭头的意思( next 本来是 null 将)
        head.next.next = head;
        head.next = null;
        // p 应该一直是尾节点，不会变，最后作为新链表的头结点输出
        return p;
    }

    /**
     * @description: 方法 2 普通的方法
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //临时保存下一个节点
            ListNode nextTemp = curr.next;
            //调整箭头的指向
            curr.next = prev;
            //依次往后挪动节点
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
