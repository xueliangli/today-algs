package algs.sort;
import algs.sort.utils.SortUtil;
/*************************************************************************
 *
 * 冒泡法：
 * 重点是判断条件是 j+1 和 j 索引处的值进行比较。
 *
 * 一个小问题
 * SortUtil.less() 使用这个方法进行比较时，只能进行一位数字的比较，或者是采用字符串，因为比较的是asc码值
 *
 *************************************************************************/
public class BubbleSort {
    private static void sort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (SortUtil.less(a[j+1],a[j])) {
                    SortUtil.exchange(a,j+1,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] a={"2","4","6","1","3","7","9","5"};
        BubbleSort.sort(a);
        SortUtil.show(a);
    }
}
