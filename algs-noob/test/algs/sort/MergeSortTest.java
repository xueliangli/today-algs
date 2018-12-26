package algs.sort;

import org.junit.Test;

import static algs.sort.MergeSort.mergeSortUp2Down;

public class MergeSortTest {
    @Test
    public void testMergeSort(){
            int i;
            int a[] = {80,30,60,40,20,10,50,70};

            System.out.print("before sort:");
            for (i=0; i<a.length; i++)
                System.out.printf("%d ", a[i]);
            System.out.print("\n");

            mergeSortUp2Down(a, 0, a.length-1);        // 归并排序(从上往下)
            //mergeSortDown2Up(a);                    // 归并排序(从下往上)

            System.out.print("after  sort:");
            for (i=0; i<a.length; i++)
                System.out.printf("%d ", a[i]);
            System.out.print("\n");
    }
}
