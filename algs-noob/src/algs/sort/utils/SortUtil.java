package algs.sort.utils;

import edu.princeton.cs.algs4.StdOut;

public class SortUtil {
    /**
     * 判断 v 是否小于 w
     *
     * .compareTo() 返回值有正负零三种情况
     * v = w 返回0   less方法返回false
     * v < w 返回-1  less方法返回true
     * v > w 返回1   less方法返回false
     * */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 判断 v 是否大于 w
     *
     * .compareTo() 返回值有正负零三种情况
     * v = w 返回0   more方法返回false
     * v < w 返回-1  more方法返回false
     * v > w 返回1   more方法返回true
     * */
    //
    public static boolean more(Comparable v, Comparable w) {
        return w.compareTo(v) < 0;
    }

    /**
     * 交换以 i， j 为坐标的数组值
     * */
    public static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    /**
     * 显示数组
     * */
    public static void show(Comparable[] a) {
        for (Comparable anA : a) {
            StdOut.print(anA + " ");
        }
        StdOut.println();
    }
}
