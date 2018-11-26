package com.xueliangli.utils;

public class StringUtil {
    /**
     * 求next数组的方法
     *
     * @param subStr 待求的子串
     * @param next   存放求出来next值的数组
     */
    public static void getNext(String subStr, int[] next) {
        int subLen = subStr.length();
        char[] chars = subStr.toCharArray();

        // next[0] = -1, 若没有前后缀相同的，next[] = 0, 以此类推
        int i = 0;
        int j = -1;
        next[0] = -1;

        while (i < subLen - 1) {
            if (j == -1 || chars[i] == chars[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    /**
     * 求next数组的方法升级版
     *
     * @param subStr 待求的子串
     * @param next   存放求出来next值的数组
     */
    public static void getNextUp(String subStr, int[] next) {
        int subLen = subStr.length();
        char[] chars = subStr.toCharArray();

        // next[0] = -1, 若没有前后缀相同的，next[] = 0, 以此类推
        int i = 0;
        int j = -1;
        next[0] = -1;

        while (i < subLen - 1) {
            if (j == -1 || chars[i] == chars[j]) {
                i++;
                j++;
                //较之前next数组求法，改动在下面4行
                if (chars[i] != chars[j])
                    next[i] = j;   //之前只有这一行
                else
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[i] = next[j];
                next[i] = j;

            } else {
                j = next[j];
            }
        }
    }
}
