package utils;

import edu.princeton.cs.algs4.StdOut;

public class SortUtil {

    public static void sort(Comparable[] a) {

    }
    /**
     * 判断 v 是否小于 w
     *
     * .compareTo() 返回值有正负零三种情况
     * v = w 返回0   less方法返回false
     * v < w 返回-1  less方法返回true
     * v > w 返回1   less方法返回false
     * */
    //
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

//    public void outResult(){
//        String[] a = In.readStrings("test-resource/sort-test-100000-words-new.txt");
//        Date date1 = new Date();
//        long t1 = date1.getTime();
//        sort(a);
//        Date date2 = new Date();
//        long t2 = date2.getTime();
//        assert SortUtil.isSorted(a);
//        System.out.println("==================排序结果为=================");
//        SortUtil.show(a);
//        System.out.println("============================================");
//        System.out.println("算法用时为：" + (t2 - t1) + "毫秒");
//    }

}
