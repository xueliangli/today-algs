package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: algs-noob
 * @description: 一个将字符串文本通过空格分割转换成字符串数据的工具
 * @author: 李学亮    emil: 18222027300@163.com
 * @create: 2019-01-09 20:43
 **/
public class StringTxtToArrayUtil {
    /**
     * @description: 通过 Scanner 类进行转换
     * @param: [filename] [文件名]
     * @return: java.util.List<java.lang.String>
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:52
     */
    public static List<String> toArray(String filename) throws FileNotFoundException {
        File file = new File(filename);
        List<String> strArray = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("该文件不存在！");
            System.exit(0);
        }
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            strArray.add(sc.next());
        }
        return strArray;
    }
}
