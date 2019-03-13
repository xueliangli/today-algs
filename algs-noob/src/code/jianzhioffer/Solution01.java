package code.jianzhioffer;

/**
 * @program: algs-noob
 * @description: 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @analysis: 二维数据，递增的规律，输入输出。从右上角或者左下角开始，因为判断的不同横纵坐标进行不同的操作
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-02-20 16:31
 **/
public class Solution01 {
    /**
     * @description:
     * @param: []
     * @return:
     * @author: 李学亮
     * @date: 2019/2/20
     * @time: 16:32
     */
    public static boolean Find(int target, int[][] array) {
        int len = array.length - 1;
        int i = 0;
        while ((len >= 0) && (i < array[0].length)) {
            if (array[len][i] > target) {
                len--;
            } else if (array[len][i] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 20;
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Find(target, array));
    }
}
/* @tips : ~
 *
 * 二维数组的表示方法，第一个数表示列，第二个数表示行
 *
 *
 */


