package algs.sort;

import algs.sort.utils.SortUtil;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void testBubbleSort(){
            String[] a={"2","4","6","1","3","7","9","5"};
            BubbleSort.sort(a);
            SortUtil.show(a);
    }
}
