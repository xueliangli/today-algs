
/*************************************************************************
 * TwoSum()
 *
 * input :
 * 8Kints.txt
 *
 * output :
 * count	===	19
 * time	===	92 ms
 *
 *
 *************************************************************************/

class TwoSum {
    static int count(int[] a){
        int N = a.length;
        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (a[i]+a[j]==0)
                    ++cnt;
            }
        }
        return cnt;
    }
}
