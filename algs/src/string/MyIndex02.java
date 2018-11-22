package string;

public class MyIndex02 {
    /**
     * 朴素的模式匹配算法
     * <p>
     * 循环前要先判断用for还是while，什么情况下选择哪一个，现在我还不知道准则？？？？？？？？？？
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

    public static void main(String[] args) {
        String str1 = "gitbook";
        String str2 = "book";
        System.out.println(index(str1, str2));
    }
}
