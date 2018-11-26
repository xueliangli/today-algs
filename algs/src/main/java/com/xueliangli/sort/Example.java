package com.xueliangli.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
/**
 * 本类是排序算法的模板类
 * 进行排序算法练习时代码补充sort部分即可
 * */
public class Example {
    /**
     * 排序算法
     * */
    private static void sort(Comparable[] a) {
    }

    /**
     * 判断 v 是否小于 w
     * */
    //.compareTo() 返回值有正负零三种情况
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换以 i， j 为坐标的数组值
     * */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    /**
     * 显示数组
     * */
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    //判断是否进行过排序
    private static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                //前一个元素大于后一个元素说明没有排序过
                return false;
            }
        }
        return true;
    }

    /**
     * 断言：assert [boolean 表达式]
     * 如果[boolean表达式]为true，则程序继续执行。
     * 如果为false，则程序抛出AssertionError，并终止执行。
     * */
    public static void main(String[] args) {
        String[] a= In.readStrings("test-resource/sort-test-100000words-new.txt");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
