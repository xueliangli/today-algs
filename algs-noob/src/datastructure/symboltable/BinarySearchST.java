package datastructure.symboltable;

/**
 * @program: algs-noob
 * @description: 基于有序数组(键的数组有序)的符号表实现，采用二分查找进行优化
 * @author: 李学亮    emil: 18222027300@163.com
 * @create: 2019-01-09 22:01
 **/
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    /**
     * @description:
     * @param: [capacity]
     * @return:
     * @author: 李学亮
     * @date:
     * @time: TODO:将数组转变成动态数组，标准代码参考算法 1.1
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
     * @description: 二分查找的应用
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
        //将返回索引往后的元素都向后挪一个位置
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }
}
