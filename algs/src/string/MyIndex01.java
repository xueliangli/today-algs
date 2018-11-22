package string;

public class MyIndex01 {
    /**
     * 利用java自带api实现
     *
     * 重点：
     * .substring 方法包含起始索引，不包含结束索引
     * 循环的边界条件，当索引剩下的子串长度小于要判断的子串时结束，等于号不能少！！！
     *
     * @param mainStr 主串
     * @param subStr 要判断的子串
     * @return int index
     * */
    private static int index(String mainStr, String subStr) {
        int lenMain = mainStr.length();
        int lenSub = subStr.length();

        for (int start = 0; start <= lenMain - lenSub; start++) {
            String str = mainStr.substring(start, start + lenSub);
            if (str.compareTo(subStr) != 0) {
                continue;
            }
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "gitbook";
        String str2 = "book";
        System.out.println(index(str1, str2));
    }
}
