
/*************************************************************************
 * Threesum()
 *
 * input :
 * 2Kints.txt
 *
 * output :
 * count	===	528
 * time	    ===	2358 ms
 *
 *************************************************************************/

public class ThreeSum {
    /**
     * 暴力法求三数之和为0的个数
     *
     * 三层 for 循环
     * @param a 操作数组
     * @return count 个数
     * */
    private static int count(int[] a){
        int N = a.length;
        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if(a[i]+a[j]+a[k]==0){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
