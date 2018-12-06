import utils.SortUtil;

import java.util.Arrays;

class Selection01 {


    /**
     * 排序算法
     */
    static void sort(Comparable[] a) {

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
        Comparable[] a = {2, 1, 4, 5, 3, 9, 8, 2, 3, 3, 9, 7, 6};
        sort(a);
        System.out.println(Arrays.toString(a));
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
