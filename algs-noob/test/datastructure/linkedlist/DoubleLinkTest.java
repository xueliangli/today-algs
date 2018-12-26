package datastructure.linkedlist;

import datastructure.domain.Student;
import org.junit.Test;

/**
 * 关于双向链表的测试
 */
public class DoubleLinkTest {
    @Test
    public void testDoubleLink() {
        int[] arr = {10, 20, 30, 40, 1, 2, 3, 4, 5, 6};

        System.out.println("\n----int_test----");
        // 创建双向链表
        DoubleLink<Integer> integerDoubleLink = new DoubleLink<>();
        // 将 20 插入到第一个位置
        integerDoubleLink.insert(0, arr[1]);
        // 将 10 追加到链表末尾
        integerDoubleLink.appendLast(arr[0]);
        // 将 30 插入到第一个位置
        integerDoubleLink.insertFirst(arr[2]);
        for (int i = 3; i < arr.length; i++) {
            integerDoubleLink.appendLast(arr[i]);
        }
        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", integerDoubleLink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", integerDoubleLink.size());
        System.out.println(integerDoubleLink.getFirstData());
        System.out.println(integerDoubleLink.getLastData());

        // 打印出全部的节点
        for (int i = 0; i < integerDoubleLink.size(); i++)
            System.out.println("integerDoubleLink(" + i + ")=" + integerDoubleLink.getData(i));
        System.out.println("======删除首尾元素后======");
        integerDoubleLink.deleteFirst();
        integerDoubleLink.deleteLast();
        for (int i = 0; i < integerDoubleLink.size(); i++)
            System.out.println("integerDoubleLink(" + i + ")=" + integerDoubleLink.getData(i));
        //=================================================================================
        String[] strings = {"ten", "twenty", "thirty", "forty"};

        System.out.println("\n----string_test----");
        // 创建双向链表
        DoubleLink<String> stringDoubleLink = new DoubleLink<>();

        stringDoubleLink.insert(0, strings[1]);    // 将 sarr中第2个元素 插入到第一个位置
        stringDoubleLink.appendLast(strings[0]);    // 将 sarr中第1个元素 追加到链表末尾
        stringDoubleLink.insertFirst(strings[2]);    // 将 sarr中第3个元素 插入到第一个位置

        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", stringDoubleLink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", stringDoubleLink.size());

        // 打印出全部的节点
        for (int i = 0; i < stringDoubleLink.size(); i++)
            System.out.println("stringDoubleLink(" + i + ")=" + stringDoubleLink.getData(i));
        //=================================================================================
        Student[] students = new Student[]{
                new Student(10, "sky"),
                new Student(20, "jody"),
                new Student(30, "vic"),
                new Student(40, "dan"),
        };
        System.out.println("\n----object_test----");
        // 创建双向链表
        DoubleLink<Student> studentDoubleLink = new DoubleLink<>();

        studentDoubleLink.insert(0, students[1]);    // 将 students中第2个元素 插入到第一个位置
        studentDoubleLink.appendLast(students[0]);    // 将 students中第1个元素 追加到链表末尾
        studentDoubleLink.insertFirst(students[2]);    // 将 students中第3个元素 插入到第一个位置

        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", studentDoubleLink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", studentDoubleLink.size());

        // 打印出全部的节点
        for (int i = 0; i < studentDoubleLink.size(); i++) {
            System.out.println("studentDoubleLink(" + i + ")=" + studentDoubleLink.getData(i));
        }
    }
}
