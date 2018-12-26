package algs.sort;


import algs.sort.utils.SortUtil;
import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.Date;

public class QuickSortTest {
    /**
     * 第一种快速排序算法
     * */
    @Test
    public void testQuick01() {

        /*
        *
        * 建议使用 ：String[] a = new In("tiny.txt").readAllStrings();
        * @deprecated Replaced by {@code new In(filename)}.{@link #readAllStrings()}.
        * 注意看注释，描述的很清楚，已经用什么样的方法来代替
        *
        * */
        String srcFile="sort-test-100000-words-new.txt";
        String[] a = new In(srcFile).readAllStrings();
        Date date1 = new Date();
        long t1 = date1.getTime();
        QuickSortFirst.sort(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
        System.out.println("==================排序结果为=================");
        SortUtil.show(a);
        System.out.println("============================================");
        System.out.println("算法用时为：" + (t2 - t1) + "毫秒");
    }

    /**
     * 第二种快速排序算法
     * */
    @Test
    public void testQuick02() {
        String srcFile="sort-test-100000-words-new.txt";
        String[] a = new In(srcFile).readAllStrings();
        Date date1 = new Date();
        long t1 = date1.getTime();
        QuickSortSecond.sort(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
        System.out.println("==================排序结果为=================");
        SortUtil.show(a);
        System.out.println("============================================");
        System.out.println("算法用时为：" + (t2 - t1) + "毫秒");

    }

}
