package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import utils.SortUtil;

public class Quick01 {
    private static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
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
        String[] a = In.readStrings("test-resource/number-test.txt");
        SortUtil.show(a);
        sort(a);
        assert SortUtil.isSorted(a);
        SortUtil.show(a);
    }
}
