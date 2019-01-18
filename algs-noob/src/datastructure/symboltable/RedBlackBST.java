package datastructure.symboltable;


/**
 * @program: algs-noob
 * @description: 基于红黑树的平衡查找树
 * @author: 李学亮    emil: 18222027300@163.com
 * @create: 2019-01-17 09:32
 **/
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    /**
     * @description: 构造红黑树的内部节点类，初始化节点的颜色
     * @param:
     * @return:
     * @author: 李学亮
     * @date: 2019/1/17
     * @time: 9:38
     */
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int N;

        public Node(Key key, Value val, boolean color, int n) {
            this.key = key;
            this.val = val;
            this.color = color;
            N = n;
        }
    }

    /**
     * @description: 节点的附加方法 ，权限为私有
     * @param: [x]
     * @return: boolean
     * @author: 李学亮
     * @date: 2019/1/17
     * @time: 9:41
     */
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    /**
     * @description: 补充的方法，暴露给数据结构的使用者
     * @param: []
     * @return: int
     * @author: 李学亮
     * @date: 2019/1/17
     * @time: 9:43
     */
    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * @description: 标准的二叉查找树查找方法，分别包含共有和私有方法，返回值和是否好含有的方法
     * @param: [key]
     * @return: Value
     * @author: 李学亮
     * @date: 2019/1/17
     * @time: 9:51
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.val;
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return contains(root, key);
    }

    private boolean contains(Node x, Key key) {
        return (get(x, key) != null);
    }

    /**
     * @description: 红黑树的插入操作，279页
     * @param: [h, key, val]
     * @return: datastructure.symboltable.RedBlackBST<Key,Value>.Node
     * @author: 李学亮
     * @date: 2019/1/18
     * @time: 21:58
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
        //根节点总是黑色的
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, RED, 1);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            put(h.left, key, val);
        } else if (cmp > 0) {
            put(h.right, key, val);
        } else {
            h.val = val;
        }
        //三种情况并列的判断
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.right) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.N = 1 + size(h.right) + size(h.left);
        return h;
    }

    /**
     * @description: 左旋转方法，当右节点为红色，左节点为黑色时使用
     * @param: [h]
     * @return: datastructure.symboltable.RedBlackBST<Key,Value>.Node
     * @author: 李学亮
     * @date: 2019/1/18
     * @time: 21:58
     */
    private Node rotateLeft(Node h) {
        //h 节点不为空并且 h 节点的右子节点为红色则执行下面的语句
        assert (h != null) && isRed(h.right);
        //保存右子节点 x
        Node x = h.right;
        //右子节点的左节点赋值给父节点
        h.right = x.left;
        //当前节点赋值给 x 的左节点
        x.left = h;
        //指向 h 的连接颜色付给 x
        x.color = h.color;
        //指向当前 h 的连接变红
        h.color = RED;
        //h 的节点数赋值给 x
        x.N = h.N;
        //h.right.left == x.left == h.right算当下 h 的节点数
        h.N = 1 + size(h.right) + size(h.left);
        return x;
    }

    /**
     * @description: 右旋转方法，当左节点和左子节点为红色时使用
     * @param: [h]
     * @return: datastructure.symboltable.RedBlackBST<Key,Value>.Node
     * @author: 李学亮
     * @date: 2019/1/18
     * @time: 22:00
     */
    private Node rotateRight(Node h) {
        //只需要把左旋的右左调转就能实现右旋
        assert (h != null) && isRed(h.right);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.right) + size(h.left);
        return x;
    }

    /**
     * @description: 颜色转换，当左右子节点同时为红色时使用
     * @param: [h]
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/18
     * @time: 22:00
     */
    private void flipColors(Node h) {
        //h 与它的两个子节点必须颜色不同
        assert (h != null && h.right != null && h.left != null);
        assert (!isRed(h) && isRed(h.left) && isRed(h.right))
                || (isRed(h) && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
}
