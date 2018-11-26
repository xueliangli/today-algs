package com.xueliangli.sort;

import com.xueliangli.utils.SortUtil;
import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.Date;

public class Sort {
    @Test
    public void testQuick01() {
        String[] a = In.readStrings("test-resource/sort-test-100000-words-new.txt");
        Date date1 = new Date();
        long t1 = date1.getTime();
        Quick01.sort(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
//        assert SortUtil.isSorted(a);//为什么这一行总是报错？？？？？？？？？？？？？？？？？？？
        System.out.println("==================排序结果为=================");
        SortUtil.show(a);
        System.out.println("============================================");
        System.out.println("算法用时为：" + (t2 - t1) + "毫秒");
    }

    @Test
    public void testQuick02() {
        String srcFile="test-resource/sort-test-100000-words-new.txt";
        String[] a = In.readStrings(srcFile);
        Date date1 = new Date();
        long t1 = date1.getTime();
        Quick02.sort(a);
        Date date2 = new Date();
        long t2 = date2.getTime();
//        assert SortUtil.isSorted(a);
        System.out.println("==================排序结果为=================");
        SortUtil.show(a);
        System.out.println("============================================");
        System.out.println("算法用时为：" + (t2 - t1) + "毫秒");

    }
}
