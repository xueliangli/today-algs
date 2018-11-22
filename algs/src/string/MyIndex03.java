package string;

import java.util.Arrays;

public class MyIndex03 {
    /**
     * KMP模式匹配算法
     * 应用场景：abcdefg 与 abcdex
     *
     * @param mainStr 主串
     * @param subStr  要判断的子串
     * @return int index
     */
    private static int index(String mainStr, String subStr) {
        char[] mainChars = mainStr.toCharArray();
        char[] subChars = subStr.toCharArray();

        int mainLen = mainChars.length;
        int subLen = subChars.length;

        if (mainLen < subLen) return -1;
        if (mainLen == subLen && (mainStr.compareTo(subStr)) != 0) return -1;

        int i = 0;
        int j = 0;
        while (i < mainLen && j < subLen) {
            if (mainChars[i] == subChars[j]) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == subLen) return i - subLen;
        return -1;
    }

    private static void getNext(String subStr, int[] next) {
        int subLen = subStr.length();
        char[] chars = subStr.toCharArray();

        int i = 1;
        int j = 0;
        next[0] = 0;

        while (i < subLen - 1) {
            if (j == 0 || chars[i] == chars[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static void main(String[] args) {
//        String str1 = "gitbook";
//        String str2 = "book";
        String str3 = "ababaaaba";

        int[] next = new int[str3.length()];
        getNext(str3, next);
        System.out.println(Arrays.toString(next));
//        System.out.println(index(str1, str2));
    }
}
