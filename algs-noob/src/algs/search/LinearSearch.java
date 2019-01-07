package algs.search;

/**
 * @program: algs-noob
 * @description: 线性查找方法
 * @author: 李学亮
 * @create: 2019-01-07 11:01
 **/
public class LinearSearch {
    /**
     * @Description: 普通方法
     * @Param: [data, target] [要查找的数组，目标数字]
     * @return: int 返回目标的索引
     * @Author: 李学亮
     * @Date: 2019/1/7
     */
    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {2, 1, 4, 6, 12, 7};
        int target = 12;
        int searchIndex = search(data, target);
        if (searchIndex != -1) {
            System.out.println("found at: " + searchIndex);
        }else {
            System.out.println("not found");
        }
    }
}
