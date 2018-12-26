package algs.sort;

import org.junit.Test;

import static algs.sort.ShellSort.shellSort01;
import static algs.sort.ShellSort.shellSort02;

public class ShellSortTest {
    /**
     * 测试希尔排序1
     * */
    @Test
    public void testShellSort(){
        int i;
        int a[] = {80,30,60,40,20,10,50,70};

        System.out.print("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        shellSort01(a, a.length);
        //shellSort02(a, a.length);

        System.out.print("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }
    /**
     * 希尔排序算法2
     * */
    @Test
    public void testShellSort02() {
        int i;
        int a[] = {80,30,60,40,20,10,50,70};

        System.out.print("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        shellSort02(a, a.length);
        //shellSort02(a, a.length);

        System.out.print("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

    }
}
