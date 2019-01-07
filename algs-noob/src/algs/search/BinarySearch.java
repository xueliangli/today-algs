package algs.search;

/**
 * @program: algs-noob
 * @description: 二分查找，前提是有序的序列
 * @author: 李学亮
 * @create: 2019-01-07 11:07
 **/
public class BinarySearch {
    /**
     * @Description: 递归实现
     * @Param: [data, left, right, target] [数组，左端点，右端点，目标值]
     * @return: int 索引值
     * @Author: 李学亮
     * @Date: 2019/1/7
     */
    public static int searchRecursion(int[] data, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] < target) {
                return searchRecursion(data, mid + 1, right, target);
            } else if (data[mid] > target) {
                return searchRecursion(data, left, mid - 1, target);
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * @Description: 循环实现
     * @Param: [data, left, right, target] [数组，左端点，右端点，目标值]
     * @return: int 索引值
     * @Author: 李学亮
     * @Date: 2019/1/7
     */
    public static int searchLoop(int[] data, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] < target) {
                left = mid + 1;
            } else if (data[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 5, 6, 12, 15, 19, 23, 26, 30, 33, 37, 42, 53, 60};
        int target = 19;
        int index = searchRecursion(data, 0, data.length - 1, target);
        if (index > -1) {
            System.out.println("found ：" + index);
        }else {
            System.out.println("not found");
        }
        System.out.println("==========================================");
        index = searchLoop(data, 0, data.length - 1, target);
        if (index > -1) {
            System.out.println("found ：" + index);
        }else {
            System.out.println("not found");
        }
    }
}