package code.jianzhioffer;

/**
 * @program: algs-noob
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @analysis: 两种方法：使用 stringbuffer 和不使用,主要用到字符数组和字符串之间的转化
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-02-20 16:57
 **/
public class Solution02 {
    /**
     * @description: 需要计算所需的空间，然后从后往前移动
     * @param: []
     * @return:
     * @author: 李学亮
     * @date: 2019/2/20
     * @time: 17:03
     */
    public static String replaceSpace(StringBuffer str) {
        //输入为空则返回空
        if (str == null) {
            return null;
        }
        int blankNum = 0;
        int length = str.length();
        int newLength;
        //统计空格个数
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                blankNum++;
            }
        }
        //新的字符串长度
        newLength = length + blankNum * 2;
        //一个字符数组作为中间容器
        char[] newChars = new char[newLength];
        int index = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                newChars[index--] = '0';
                newChars[index--] = '2';
                newChars[index--] = '%';
            } else {
                newChars[index--] = str.charAt(i);
            }
        }
        return new String(newChars);
    }

    /**
     * @description: 直接利用 stringbuffer 的方法
     * @param: []
     * @return:
     * @author: 李学亮
     * @date: 2019/2/20
     * @time: 17:30
     */
    public static String replaceSpace02(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * @description: 单元测试
     * @param: []
     * @return:
     * @author: 李学亮
     * @date: 2019/2/20
     * @time: 17:31
     */
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.insert(0, "you are happy");
        System.out.println(replaceSpace(str));
        System.out.println(replaceSpace02(str));
    }
}
/* @tips : ~
 *
 * StringBuffer 用法，初始化用 new 注意 append 方法和 insert 方法
 * 方法二中最后返回之前需要转换成字符串类型
 *
 */
