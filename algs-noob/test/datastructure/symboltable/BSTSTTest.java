package datastructure.symboltable;

import org.junit.Test;
import utils.StringTxtToArrayUtil;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @program: algs-noob
 * @description: 测试二叉树符号表
 * @author: 李学亮    emil: 18222027300@163.com
 * @create: 2019-01-14 22:42
 **/
public class BSTSTTest {
    @Test
    public void testBSTST() throws FileNotFoundException {
        List<String> strList = StringTxtToArrayUtil.toArray("algs4/3-Searching/3-2-BinarySearchTrees/tinyST.txt");
        BSTST<String, Integer> bst = new BSTST<>();
        //将长度大于8的单词及存在的次数存放到符号表中
        for (String s : strList) {
            if (!bst.contains(s)) {
                bst.put(s, 1);
            } else {
                bst.put(s, bst.get(s) + 1);
            }
        }

        for (String s : bst.keys()) {
            System.out.println(s + " === " + bst.get(s));
        }

    }
}
