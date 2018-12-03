
public class BinarySearch {
    private BinarySearch() {
    }

    //递归实现
    private static int indexOfNew(int[] a,int key){
        return indexOfNew(a,key,0,a.length);
    }

    private static int indexOfNew(int[] a,int key,int lo,int hi){
        int mid = lo + (hi - lo) / 2;
        if (lo>hi)return -1;
        if (key<a[mid])return indexOfNew(a,key,lo,mid-1);
        else if (key>a[mid])return indexOfNew(a,key,mid+1,hi);
        else return mid;
    }

    //迭代实现
    private static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else {
                if (key <= a[mid])
                    return mid;
                lo = mid + 1;
            }
        }
        return -1;
    }

    private static int rank(int key, int[] a) {
        return indexOf(a, key);
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,10};
        System.out.println(indexOf(a,2));
        System.out.println(rank(2,a));
        System.out.println(indexOfNew(a,2));
    }
}
