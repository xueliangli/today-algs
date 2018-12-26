package algs.sort;

import algs.sort.utils.SortUtil;
import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.Date;

public class SelectSortTest {
    /**
     * 选择排序算法
     * */
    @Test
    public void testSelection01() {
        String srcFile="sort-test-100000-words-new.txt";
        String[] a = new In(srcFile).readAllStrings();
        Date date1 = new Date();
        long t1 = date1.getTime();
        SelectSort.sort(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
        System.out.println("==================排序结果为=================");
        SortUtil.show(a);
        System.out.println("============================================");
        System.out.println("算法用时为：" + (t2 - t1) + "毫秒");

    }
}
