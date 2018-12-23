package algs.sort;
import algs.sort.utils.SortUtil;
import edu.princeton.cs.algs4.StdRandom;
/*************************************************************************
 *
 * 第二种快速排序的方法：
 *
 *************************************************************************/
public class QuickSortSecond {
    /**
     * 为了使用户只需输入一个数组，简化交互
     *
     * @param a 待排序的数组
     */
    public static void sort(Comparable[] a) {
        //对输入数组进行随机化处理
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * 对sort方法的递归
     * 第二次分区时，左边子数组：lo = 0 hi = j - 1
     * 第二次分区时，右边子数组：lo = j + 1 hi = len - 1
     *
     * @param a  待操作的数组
     * @param lo 开始处的索引，相当于指针
     * @param hi 结束处的索引，相当于指针
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        //递归结束的基线条件，说明子数组只剩下最后一个元素了
        if (hi <= lo)
            return;
        //每次sort前需要先分区
        int[] border = partition(a, lo, hi);
        sort(a, lo, border[0] - 1);
        sort(a, border[1] + 1, hi);
    }

    /**
     * 分区:目的是将数组a分成小于基准值，等于基准值，大于基准值的三部分
     * 第一次分区时，lo = 0 hi = len - 1
     *
     * @param array 待操作的数组
     * @param lo    开始处的索引，相当于指针
     * @param hi    结束处的索引，相当于指针
     * @return int[] border 有相等元素时，分别返回左右分割点索引
     */
    private static int[] partition(Comparable[] array, int lo, int hi) {
        int i = lo - 1;
        int j = hi + 1;
        int cur = lo;
        //选择基准值，随机选择
        int compare = hi-1;
        while (cur < j) {
            if (SortUtil.less(array[cur], array[compare]))
                SortUtil.exchange(array, ++i, cur++);
            else if (SortUtil.more(array[cur], array[compare]))
                SortUtil.exchange(array, --j, cur);
            else
                cur++;
        }
        return new int[]{i, j};
    }
}
