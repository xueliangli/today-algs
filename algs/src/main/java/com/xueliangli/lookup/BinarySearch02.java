package com.xueliangli.lookup;

public class BinarySearch02 {
    /**
     * 前提：已经排好序的组合
     * 利用递归实现二分查找
     *
     * @param arr  操作数组
     * @param key  查找元素
     * @param low  二分的起点
     * @param high 二分的终点
     */
    private static int rank(int[] arr, int key, int low, int high) {
        int mid = (high - low) / 2 + low;
        if (key == arr[mid])
            return mid;
        else if (low > high)
            return -1;
        else if (key < arr[mid])
            return rank(arr, key, low, mid - 1);
        else if (key > arr[mid])
            return rank(arr, key, mid + 1, high);
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 78, 90, 100, 122, 444, 5554, 63453};
        int key = 5;
        System.out.println(rank(arr, key, 0, arr.length - 1));

    }
}
