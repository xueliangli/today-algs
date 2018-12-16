package algs.sort;
import algs.sort.utils.SortUtil;
/*************************************************************************
 *
 * 基本的选择排序法：
 *
 *
 *
 *************************************************************************/
public class SelectionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (SortUtil.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortUtil.exchange(a, i, min);
        }
    }
}
