package com.xueliangli.lookup;

public class BinarySearch01 {
    /**
     * 非递归实现二分查找
     * @param arr 操作数组
     * @param key 查找元素
     * */
    private static int rank(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (key < arr[mid]) high = mid - 1;
            else if (key > arr[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 78, 90, 100, 122, 444, 5554, 63453};
        int key = 4;
        System.out.println(rank(arr, key));

    }
}
