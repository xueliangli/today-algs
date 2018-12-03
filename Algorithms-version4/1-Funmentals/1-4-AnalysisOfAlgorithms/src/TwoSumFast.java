import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

/*************************************************************************
 * TwoSumFast()
 *
 * input :
 * 8Kints.txt
 *
 * output :
 * count	===	19
 * time	===	13 ms
 *
 *************************************************************************/

class TwoSumFast {
    static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.rank(-a[i], a) > i)
                ++cnt;
        }
        return cnt;
    }
}
