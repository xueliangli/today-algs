package utils;

import edu.princeton.cs.algs4.StdOut;

public class SortUtil {
    /**
     * 判断 v 是否小于 w
     * */
    //.compareTo() 返回值有正负零三种情况
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换以 i， j 为坐标的数组值
     * */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    /**
     * 显示数组
     * */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    //判断是否进行过排序
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                //前一个元素大于后一个元素说明没有排序过
                return false;
            }
        }
        return true;
    }

}
