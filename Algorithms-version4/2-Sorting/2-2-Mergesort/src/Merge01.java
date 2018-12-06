import utils.SortUtil;

import java.util.Arrays;

/**
 * 自顶向下的归并排序
 */
public class Merge01 {
    //归并所需要的辅助数组
    private static Comparable[] aux;

    //重载的 sort 方法，方便用户的输入
    private static void sort(Comparable[] a) {
        //为数组分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        //递归的基线条件
        if (hi <= lo)
            return;
        //中值
        int mid = lo + (hi - lo) / 2;
        //左半边进行排序
        sort(a, lo, mid);
        //右半边进行排序
        sort(a, mid + 1, hi);
        //进行原地归并
        merge(a, lo, mid, hi);
    }

    //进行原地归并
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //定义分治后左右部分的起点
        int i = lo;
        int j = mid + 1;

        //复制数组到一个新的数组,传进的数组长度参数应该加 1 ，不然会报空指针异常
        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
        //从新数组按序放回原数组的过程,等于号不能丢！！！！！！！！！！！！！！！！！！！！！！！！
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
