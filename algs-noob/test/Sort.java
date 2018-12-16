import algs.sort.QuickSortFirst;
import algs.sort.QuickSortSecond;
import algs.sort.SelectionSort;
import algs.sort.utils.SortUtil;
import edu.princeton.cs.algs4.In;
import org.junit.Test;
import java.util.Date;

public class Sort {
    /**
     * 第一种快速排序算法
     * */
    @Test
    public void testQuick01() {
        String[] a = In.readStrings("sort-test-100000-words-new.txt");
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
        String[] a = In.readStrings(srcFile);
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

    /**
     * 选择排序算法
     * */
    @Test
    public void testSelection01() {
        String srcFile="sort-test-100000-words-new.txt";
        String[] a = In.readStrings(srcFile);
        Date date1 = new Date();
        long t1 = date1.getTime();
        SelectionSort.sort(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
        System.out.println("==================排序结果为=================");
        SortUtil.show(a);
        System.out.println("============================================");
        System.out.println("算法用时为：" + (t2 - t1) + "毫秒");

    }
}
