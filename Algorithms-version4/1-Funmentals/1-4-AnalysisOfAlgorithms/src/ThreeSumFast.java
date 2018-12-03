import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

/*************************************************************************
 * ThreeSumFast()
 *
 * input :
 * 2Kints.txt
 *
 * output :
 * count	===	528
 * time	===	159 ms
 *
 *************************************************************************/

class ThreeSumFast {
    static int count(int[] a) {
        Arrays.sort(a);//内部是快排的实现
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                //查看对应的负元素是否在剩余未遍历的数组
                if (BinarySearch.rank(-a[i] - a[j], a) > j)
                    cnt++;
            }
        }
        return cnt;
    }
}
