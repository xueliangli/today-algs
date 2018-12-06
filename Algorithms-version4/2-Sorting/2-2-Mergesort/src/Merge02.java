import utils.SortUtil;

import java.util.Arrays;

/**
 * 自底向上的归并排序
 */
public class Merge02 {
    //定义辅助数组
    private static Comparable[] aux;

    //排序方法体
    private static void sort(Comparable[] a) {
        int N = a.length;
        //必不可少，该数组是静态修饰的，相当于全局变量，在此处初始化以后，在 merge 方法中也可以调用，静态的方便之处
        aux = new Comparable[N];
        // sz 代表子数组的长度，从1开始
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    //归并方法
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (SortUtil.less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {2, 1, 4, 5, 3, 9, 8, 2, 3, 3, 9, 7, 6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
