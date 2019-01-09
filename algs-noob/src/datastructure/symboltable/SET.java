package datastructure.symboltable;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/*************************************************************************
 *
 *  通过 Set 实现符号表
 *
 *************************************************************************/
public class SET<Key extends Comparable<Key>> implements Iterable<Key> {
    private TreeSet<Key> set;

    public SET() {
        set = new TreeSet<>();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * @description: 添加健到集合中
     * @param: [key]
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/9
     */
    public void add(Key key) {
        set.add(key);
    }

    /**
     * @description: 判断是否包含该健
     * @param: [key]
     * @return: boolean
     * @author: 李学亮
     * @date: 2019/1/9
     */
    public boolean contains(Key key) {
        return set.contains(key);
    }

    /**
     * @description: 删除指定的健
     * @param: [key]
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/9
     */
    public void delete(Key key) {
        set.remove(key);
    }

    /**
     * @description: 返回键的个数
     * @param: []
     * @return: int
     * @author: 李学亮
     * @date: 2019/1/9
     */
    public int size() {
        return set.size();
    }

    /**
     * @description: 返回迭代器
     * @param: []
     * @return: java.util.Iterator<Key>
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 19:42
     */
    public Iterator<Key> iterator() {
        return set.iterator();
    }

    /**
     * @description: 返回最大值对应的健
     * @param: []
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 19:43
     */
    public Key max() {
        return set.last();
    }

    /**
     * @description: 返回最小值对应的健
     * @param: []
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 19:43
     */
    public Key min() {
        return set.first();
    }

    /**
     * @description: 返回最小的健在大于 k 的范围内
     * @param: [k]
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 19:44
     */
    public Key ceil(Key k) {
        SortedSet<Key> tail = set.tailSet(k);
        if (tail.isEmpty()) return null;
        else return tail.first();
    }

    /**
     * @description: 返回最大的健在大于 k 的范围内
     * @param: [k]
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 19:44
     */
    public Key floor(Key k) {
        if (set.contains(k)) return k;

        // does not include key if present (!)
        SortedSet<Key> head = set.headSet(k);
        if (head.isEmpty()) return null;
        else return head.last();
    }

    /**
     * @description: 连接两个集合
     * @param: [that]
     * @return: datastructure.symboltable.SET<Key>
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:07
     */
    public SET<Key> union(SET<Key> that) {
        SET<Key> c = new SET<>();
        for (Key x : this) {
            c.add(x);
        }
        for (Key x : that) {
            c.add(x);
        }
        return c;
    }

    /**
     * @description: 返回两个集合相同的部分
     * @param: [that]
     * @return: datastructure.symboltable.SET<Key>
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:09
     */
    public SET<Key> intersect(SET<Key> that) {
        SET<Key> c = new SET<>();
        if (this.size() < that.size()) {
            for (Key x : this) {
                if (that.contains(x)) c.add(x);
            }
        } else {
            for (Key x : that) {
                if (this.contains(x)) c.add(x);
            }
        }
        return c;
    }

    /**
     * @description: 判断两个集合是否相等
     * @param: [y]
     * @return: boolean
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 20:09
     */
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        SET<Key> that = (SET<Key>) y;
        if (this.size() != that.size()) return false;
        try {
            for (Key k : this)
                if (!that.contains(k)) return false;
        } catch (ClassCastException exception) {
            return false;
        }
        return true;
    }
}
