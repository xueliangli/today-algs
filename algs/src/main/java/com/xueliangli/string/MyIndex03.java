package com.xueliangli.string;


import com.xueliangli.utils.StringUtil;

public class MyIndex03 {
    /**
     * KMP模式匹配算法
     * 应用场景：abcdefg 与 abcdex
     *
     * @param mainStr 主串
     * @param subStr  要判断的子串
     * @return int index
     */
    private static int index(String mainStr, String subStr, int[] next) {
        char[] mainChars = mainStr.toCharArray();
        char[] subChars = subStr.toCharArray();

        //排除一些常见的情况
        int mainLen = mainChars.length;
        int subLen = subChars.length;

        if (mainLen < subLen) return -1;
        if (mainLen == subLen && (mainStr.compareTo(subStr)) != 0) return -1;

        int i = 0;
        int j = 0;
        while (i < mainLen && j < subLen) {
            if (j == -1 || mainChars[i] == subChars[j]) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }

        if (j == subLen) return i - subLen;
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "000000000000000000001";
        String str2 = "001";
        int[] next = new int[str2.length()];
        StringUtil.getNext(str2, next);
        System.out.println(index(str1, str2, next));
    }
}
