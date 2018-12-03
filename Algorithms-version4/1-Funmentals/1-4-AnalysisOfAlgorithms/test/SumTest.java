import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ThreeSum;
import org.junit.Test;

import java.util.Date;

public class SumTest {

    @Test
    public void tesTwoSum() {
        int[] a = In.readInts("8Kints.txt");
        Date date1 = new Date();
        long t1 = date1.getTime();
        //使用算法的地方
        int count = TwoSum.count(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
        StdOut.println("count\t===\t" + count + "\ntime\t===\t" + (t2 - t1) + " ms");
    }

    @Test
    public void testTwoSumFast() {
        int[] a = In.readInts("8Kints.txt");
        Date date1 = new Date();
        long t1 = date1.getTime();
        //使用算法的地方
        int count = TwoSumFast.count(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
        StdOut.println("count\t===\t" + count + "\ntime\t===\t" + (t2 - t1) + " ms");
    }

    @Test
    public void testThreesum() {
        int[] a = In.readInts("2Kints.txt");
        Date date1 = new Date();
        long t1 = date1.getTime();
        //使用算法的地方
        int count = ThreeSum.count(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
        StdOut.println("count\t===\t" + count + "\ntime\t===\t" + (t2 - t1) + " ms");
    }

    @Test
    public void testThreeSumFast(){
        int[] a = In.readInts("2Kints.txt");
        Date date1 = new Date();
        long t1 = date1.getTime();
        //使用算法的地方
        int count = ThreeSumFast.count(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
        StdOut.println("count\t===\t" + count + "\ntime\t===\t" + (t2 - t1) + " ms");
    }
}
