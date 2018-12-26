package algs.sort;

import org.junit.Test;

import static algs.sort.HeapSort.heapSort;

public class HeapSortTest {
    @Test
    public void testHeapSort(){
            int[] arr = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
            System.out.println("排序之前：");
            for (int anArr : arr) {
                System.out.print(anArr + " ");
            }
            // 堆排序
            heapSort(arr);
            System.out.println();
            System.out.println("排序之后：");
            for (int anArr : arr) {
                System.out.print(anArr + " ");
            }
    }
}
