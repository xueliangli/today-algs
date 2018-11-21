package sort;

import edu.princeton.cs.algs4.In;
import utils.SortUtil;

import java.util.Date;

public class Selection01 {


    /**
     * 排序算法
     */
    private static void sort(Comparable[] a) {

        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (SortUtil.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortUtil.exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = In.readStrings("test-resource/sort-test-100000-words-new.txt");
        Date date1 = new Date();
        long t1 = date1.getTime();
        sort(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
        assert SortUtil.isSorted(a);
        System.out.println("==================排序结果为=================");
        SortUtil.show(a);
        System.out.println("============================================");
        System.out.println("算法用时为：" + (t2 - t1) + "毫秒");
    }
}
/*
 *in:3 2 4 45 1 8 7 9 23
 * out:1 2 23 3 4 45 7 8 9
 *
 * 因为是对字符串数组进行排序，所以是按照阿斯克码值大小进行比较
 *
 * 对10000个字符串进行排序
 * 算法用时为：40639毫秒
 * */
