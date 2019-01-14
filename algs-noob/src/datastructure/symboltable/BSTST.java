package datastructure.symboltable;

import datastructure.queue.Queue;

/**
 * @program: algs-noob
 * @description: 基于二叉查找树的符号表
 * @author: 李学亮    emil: 18222027300@163.com
 * @create: 2019-01-14 21:15
 **/
public class BSTST<Key extends Comparable<Key>, Value> {
    /**
     * @description: 构造初始二叉树符号表结构，注意键值对
     * @param:
     * @return:
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 22:20
     */
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    /**
     * @description: 简单方法
     * @param: []
     * @return: boolean
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 22:24
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.N;
        }
    }

    /**
     * @description: 得到值
     * @param: [key]
     * @return: boolean
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 22:31
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    //从根节点开始找起
    public Value get(Key key) {
        return get(root, key);
    }

    //通过递归调用，返回对应键的值
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }
    //TODO:之后的没练习，，，

    /**
     * @description: 插入到二叉树中
     * @param: [key, val]
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 22:36
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);

    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.value = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * @description: 删除指定的节点
     * @param: []
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 22:37
     */
    public void deleteMin() {
        if (isEmpty()) throw new RuntimeException("Symbol table underflow");
        root = deleteMin(root);

    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new RuntimeException("Symbol table underflow");
        root = deleteMax(root);

    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);

    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * @description: 浮动节点
     * @param: []
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 22:37
     */
    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    public Key max() {
        if (isEmpty()) return null;
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }
        return ceiling(x.right, key);
    }

    /**
     * @description:
     * @param: [k]
     * @return: Key
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 22:39
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) return null;
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    /**
     * @description:
     * @param: []
     * @return: java.lang.Iterable<Key>
     * @author: 李学亮
     * @date: 2019/1/14
     * @time: 22:39
     */
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmpLo = lo.compareTo(x.key);
        int cmpHi = hi.compareTo(x.key);
        if (cmpLo < 0) keys(x.left, queue, lo, hi);
        if (cmpLo <= 0 && cmpHi >= 0) queue.enqueue(x.key);
        if (cmpHi > 0) keys(x.right, queue, lo, hi);
    }

    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
}
