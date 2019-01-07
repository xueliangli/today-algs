package algs.math;

import java.util.Arrays;

/**
 * @program: algs-noob
 * @description: 求两个矩阵相乘的结果
 * @author: 李学亮
 * @create: 2019-01-07 14:33
 **/
public class MatrixMultiply {
    private static int[][] a = new int[2][3];
    private static int b[][] = {{1, 5, 2, 8}, {5, 9, 10, -3}, {2, 7, -5, -18}};
    private static int[][] c = new int[2][4];

    /**
     * @Description: 计算矩阵相乘
     * @Param: [a, b] [相乘矩阵，相乘矩阵]
     * @return: int[][] [结果矩阵]
     * @Author: 李学亮
     * @Date: 2019/1/7
     */
    private static int[][] multiply(int[][] a, int[][] b) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = (i + 1) * (j + 2);
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                c[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(multiply(a, b)));
    }
}