package algs.search;

import datastructure.symboltable.ST;
import utils.StringTxtToArrayUtil;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @program: algs-noob
 * @description: 以 ST 数据结构为基础，统计输入中单词出现的频率
 * @author: 李学亮    emil: 18222027300@163.com
 * @create: 2019-01-09 20:22
 **/
public class FrequencyCounter {
    public static void main(String[] args) throws FileNotFoundException {
        //只统计长度大于一定值的字符串
        int minLen = 8;
        List<String> strList = StringTxtToArrayUtil.toArray("algs4/3-Searching/3-1-SymbolTables/tale.txt");
        ST<String, Integer> st = new ST<>();
        //将长度大于8的单词及存在的次数存放到符号表中
        for (String s : strList) {
            if (s.length() < 8) continue;
            //第一次出现的单词设置值为 1
            if (!st.contains(s)) {
                st.put(s, 1);
            } else {
                st.put(s, st.get(s) + 1);
            }
        }
        //显示所有长度大于8的单词及其出现的次数
        for (String s : st.keys()) {
            System.out.println(s + " === " + st.get(s));
        }
        System.out.println("出现频率最多的是：");
        //因为 null 不能作为键，所以初始化为空格
        String max = " ";
        st.put(max, 0);
        for (String s : st.keys()) {
            if (st.get(s) > st.get(max)) {
                max = s;
            }
        }
        System.out.println(max + " === " + st.get(max));
    }
}
