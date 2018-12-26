package algs.sort;

import org.junit.Test;

import static algs.sort.InsertSort.insertSort;

public class InsertSortTest {
    @Test
    public void testInsertSort() {
        int i;
        int[] a = {20, 40, 30, 10, 60, 50};

        System.out.print("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        insertSort(a, a.length);

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }
}
