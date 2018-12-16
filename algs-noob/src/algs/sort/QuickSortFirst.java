package algs.sort;

import algs.sort.utils.SortUtil;
import edu.princeton.cs.algs4.StdRandom;

/*************************************************************************
 * 标号模板：
 *（1）（2）（3）（4）（5）（6）（7）（8）
 *（Ⅰ）（Ⅱ）（Ⅲ）（Ⅳ）（Ⅴ）（Ⅵ）（Ⅶ）（Ⅷ）（Ⅸ）（Ⅹ）（Ⅺ）（Ⅻ）
 *（一）（二）（三）（四）（五）（六）（七）（八）（九）（十）
 *  --->
 *
 * 快速排序的第一种实现方法，带有两个哨兵
 *
 * 设计思路：
 *
 *
 *************************************************************************/
public class QuickSortFirst {
    /**
     * 为了使用户只需输入一个数组，简化交互
     * @param a 待排序的数组
     * */
    public static void sort(Comparable[] a) {
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
            SortUtil.exchange(a, i, j);
        }
        SortUtil.exchange(a, lo, j);
        return j;
    }
}
