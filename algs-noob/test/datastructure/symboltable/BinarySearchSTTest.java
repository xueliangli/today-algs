package datastructure.symboltable;

import org.junit.Test;
import utils.StringTxtToArrayUtil;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @program: algs-noob
 * @description: 测试二分符号表
 * @author: 李学亮    emil: 18222027300@163.com
 * @create: 2019-01-14 19:47
 **/
public class BinarySearchSTTest {
    @Test
    public void testBinarySearchST() throws FileNotFoundException {
        List<String> strList = StringTxtToArrayUtil.toArray("algs4/3-Searching/3-1-SymbolTables/tale.txt");
        BinarySearchST<String, Integer> bst = new BinarySearchST<>();
        //将长度大于8的单词及存在的次数存放到符号表中
        for (String s : strList) {
            if (s.length() < 8) continue;
            //第一次出现的单词设置值为 1
            if (!bst.contains(s)) {
                bst.put(s, 1);
            } else {
                bst.put(s, bst.get(s) + 1);
            }
        }
        //显示所有长度大于8的单词及其出现的次数
        for (String s : bst.keys()) {
            System.out.println(s + " === " + bst.get(s));
        }

    }
}
