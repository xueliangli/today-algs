package datastructure.linkedlist;

import org.junit.Test;

public class SingleLinkTest {
    @Test
    public void testSingleLink(){
            SingleLink<Integer> ints = new SingleLink<>();
            for (int i = 0; i < 10; i++) {
                ints.insertFirst(i);
            }
            //测试显示链表
            ints.displayList();
            System.out.println("\n链表长度为：" + ints.size());

            //测试删除头节点
            ints.deleteFirst();
            System.out.println("\n删除后的链表为：\n");
            ints.displayList();
            System.out.println("\n链表长度为：" + ints.size());

            //测试删除指定内容的节点
            System.out.println("\n删除后的链表为：\n");
            ints.deleteNode(3);
            ints.displayList();
            System.out.println("\n链表长度为：" + ints.size());
    }
}
