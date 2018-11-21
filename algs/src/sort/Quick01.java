package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtil;

import java.util.Date;

public class Quick01{
    /**
     * 为了使用户只需输入一个数组，简化交互
     * @param a 待排序的数组
     * */
    private static void sort(Comparable[] a) {
        //对输入数组进行随机化处理
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * 对sort方法的递归
     * 第二次分区时，左边子数组：lo = 0 hi = j - 1
     * 第二次分区时，右边子数组：lo = j + 1 hi = len - 1
     * @param a 待操作的数组
     * @param lo 开始处的索引，相当于指针
     * @param hi 结束处的索引，相当于指针
     * */
    private static void sort(Comparable[] a, int lo, int hi) {
        //递归结束的基线条件，说明子数组只剩下最后一个元素了
        if (hi <= lo)
            return;
        //每次sort前需要先分区
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 分区:目的是将数组a分成小于基准值，等于基准值，大于基准值的三部分
     * 第一次分区时，lo = 0 hi = len - 1
     * @param a 待操作的数组
     * @param lo 开始处的索引，相当于指针
     * @param hi 结束处的索引，相当于指针
     * @return int j 基准值的坐标
     * */
    private static int partition(Comparable[] a, int lo, int hi) {
        //lo指向数组第一个元素，hi指向数组尾元素的后一个元素
        int i = lo, j = hi + 1;
        //选取首元素作为基准值（不会再变化）
        Comparable v = a[lo];

        //i哨兵的目的是从左向右找出第一个大于基准值的数的索引
        //j哨兵的目的是从右向左找出第一个小于基准值的数的索引
        while (true) {
            while (SortUtil.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (SortUtil.less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            SortUtil.exch(a, i, j);
        }
        SortUtil.exch(a, lo, j);
        return j;
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
* 对100000个字符串进行排序
* 算法用时为：110毫秒
*
* */
