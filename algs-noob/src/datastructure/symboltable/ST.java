package datastructure.symboltable;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/*************************************************************************
 *
 *  通过 TreeMap 实现符号表
 *
 *************************************************************************/
public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private TreeMap<Key, Value> st;

    public ST() {
        st = new TreeMap<>();
    }

    public void put(Key key, Value val) {
        if (val == null) st.remove(key);
        else st.put(key, val);
    }

    /**
     * @description: 返回指定健对应的值
     * @param: [key]
     * @return: Value
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:11
     */
    public Value get(Key key) {
        return st.get(key);
    }

    /**
     * @description: 删除指定的健
     * @param: [key]
     * @return: Value
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:11
     */
    public Value delete(Key key) {
        return st.remove(key);
    }

    /**
     * @description: 判断是否包含相应的建
     * @param: [key]
     * @return: boolean
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:11
     */
    public boolean contains(Key key) {
        return st.containsKey(key);
    }

    /**
     * @description: 得到健的个数
     * @param: []
     * @return: int
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:12
     */
    public int size() {
        return st.size();
    }

    /**
     * @description: 得到迭代器，能够使用 foreach 进行遍历
     * @param: []
     * @return: java.lang.Iterable<Key>
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:12
     */
    public Iterable<Key> keys() {
        return st.keySet();
    }

    /**
     * @description: 能够通过 foreach 进行遍历
     * @param: []
     * @return: java.util.Iterator<Key>
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:16
     */
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    /**
     * @description: 返回最小的健
     * @param: []
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:13
     */
    public Key min() {
        return st.firstKey();
    }

    /**
     * @description: 返回最大的键
     * @param: []
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:14
     */
    public Key max() {
        return st.lastKey();
    }


    /**
     * @description: 返回大于 k 的最小的键
     * @param: [k]
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:14
     */
    public Key ceil(Key k) {
        SortedMap<Key, Value> tail = st.tailMap(k);
        if (tail.isEmpty()) return null;
        else return tail.firstKey();
    }

    /**
     * @description: 返回大于 k 的最大的键
     * @param: [k]
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:14
     */
    public Key floor(Key k) {
        if (st.containsKey(k)) return k;
        SortedMap<Key, Value> head = st.headMap(k);
        if (head.isEmpty()) return null;
        else return head.lastKey();
    }
}
