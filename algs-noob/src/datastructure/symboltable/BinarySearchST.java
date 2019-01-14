package datastructure.symboltable;

import utils.StringTxtToArrayUtil;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @program: algs-noob
 * @description: 基于有序数组(键的数组有序)的符号表实现，采用二分查找进行优化
 * @author: 李学亮    emil: 18222027300@163.com
 * @create: 2019-01-09 22:01
 * TODO:将数组转变成动态数组，标准代码参考算法 1.1 完成
 * TODO:断言关键词的使用，check 函数
 **/
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;

    public Key[] getKeys() {
        return keys;
    }

    private Key[] keys;
    private Value[] values;
    private int N;

    /**
     * @description: 创建初始化为空数组的构造函数
     * @param: []
     * @return:
     * @author: 李学亮
     * @date:
     * @time:
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }


    /**
     * @description: 带参数的构造函数
     * @param: [capacity]
     * @return:
     * @author: 李学亮
     * @date:
     * @time:
     */
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @description: 通过键得到值
     * @param: [key]
     * @return: Value
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 22:35
     */
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    /**
     * @description: 排名的方法，最关键
     * @param: [key]
     * @return: int 找到则返回key在数组中的位置，未找到目标则返回 比目标key的索引大1的索引；
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 22:25
     */
    private int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        //这里值并不是0，而是经过查找指针停留在的位置
        return lo;
    }

    /**
     * @description: 得到新的是数组，数组长度有输入的参数决定
     * @param: [capacity] 新数组的长度
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 19:33
     */
    private void resize(int capacity) {
        assert capacity >= N;
        //注意参数
        Key[] tempK = (Key[]) new Comparable[capacity];
        Value[] tempV = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempK[i] = keys[i];
            tempV[i] = values[i];
        }
        values = tempV;
        keys = tempK;
    }

    /**
     * @description: 查找键，找到则更新值，否则创建新的元素
     * @param: [key, value]
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 22:47
     */
    public void put(Key key, Value value) {
        int i = rank(key);
        //找到了，就更新值
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        //添加判断现有数组长度的代码，到最后一个位置就将数组长度扩充二倍
        if (N == keys.length) {
            resize(2 * keys.length);
        }
        //将返回索引往后的元素都向后挪一个位置
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    /**
     * @description: 删除镇定的键，注意判断数组的饱和度
     * @param: [key]
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 20:10
     */
    public void delete(Key key) {
        if (isEmpty()) return;
        int i = rank(key);
        //判断健是否在表中
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        N--;
        keys[N] = null;
        values[N] = null;

        if (N > 0 && N < keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    /**
     * @description: 判断是否含有指定键
     * @param: [key]
     * @return: boolean
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 20:14
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * @description: 简单测试
     * @param: [args]
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 20:23
     */
    public static void main(String[] args) throws FileNotFoundException {
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
        for (String s : bst.getKeys()) {
            System.out.println(s + " === " + bst.get(s));
        }
    }
}
/*
 * Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Comparable; cannot be cast to [Ljava.lang.String;
 * at datastructure.symboltable.BinarySearchST.main(BinarySearchST.java:219)
 *
 * 报错
 * */
