package data_structure.tree;

/*************************************************************************
 * 标号模板：
 *（1）（2）（3）（4）（5）（6）（7）（8）
 *（Ⅰ）（Ⅱ）（Ⅲ）（Ⅳ）（Ⅴ）（Ⅵ）（Ⅶ）（Ⅷ）（Ⅸ）（Ⅹ）（Ⅺ）（Ⅻ）
 *（一）（二）（三）（四）（五）（六）（七）（八）（九）（十）
 *  --->
 *
 * 二叉树的三叉链表存储结构表示
 *
 * 设计思路：
 * 成员变量：根节点
 * 二叉树的节点，包括：（1）数据（2）左孩子指针 （3）右孩子指针 （4）父节点指针 (5)内部类的构造
 * 树的构造方法：根节点设为空
 * 插入节点：涉及变量，输入参数：（1）原来的树（2）要加入的节点；中间变量：（1）进行遍历的节点（2）确定的为插入节点的父节点；判断左右孩子的标志
 * 新建节点：方便用户输入，重载插入节点的方法
 * 打印二叉树：
 * 三种方式遍历二叉树：（1）前序：节点 ---> 左孩子 ---> 右孩子 （2）中序：左孩子 ---> 节点 ---> 右孩子（3）后序：孩子 ---> 节点 ---> 根（4）层序：空间上自上而下，从左往右
 * ===========这之后功能未实现===========
 * 删除节点
 * 查找：（1）对应数据的节点（2）最大值节点（3）最小值节点（4）相应节点的前驱（5）相应节点的后继
 * 销毁二叉树
 *************************************************************************/
public class BSTree<Item extends Comparable> {
    //根节点
    private BSTNode mRoot;
    /**
     * 定义内部节点类
     * 包含属性：数据，左孩子，右孩子，父节点
     * */
    private class BSTNode {
        private Item data;
        private BSTNode leftChild;
        private BSTNode rightChild;
        private BSTNode parent;
        /**
         * 构造方法对节点类进行初始化
         * */
        BSTNode(Item data, BSTNode leftChild, BSTNode rightChild, BSTNode parent) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

        /**
         * 格式化输出
         * */
        @Override
        public String toString() {
            return "BSTNode{" +
                    "data=" + data +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    ", parent=" + parent +
                    '}';
        }
    }

    /**
     * 树的构造器
     * */
    public BSTree() {
        mRoot = null;
    }

    /**
     * 插入节点方法
     * */
    private void insert(BSTree bst, BSTNode z) {
        int cmp;
        BSTNode y = null;
        BSTNode x = bst.mRoot;
        while (x != null) {
            y = x;
            cmp = (z.data).compareTo(x.data);
            if (cmp < 0)
                x = x.leftChild;
            else
                x = x.rightChild;
        }
        z.parent = y;
        if (y == null)
            bst.mRoot = z;
        else {
            cmp = z.data.compareTo(y.data);
            if (cmp < 0)
                y.leftChild = z;
            else
                y.rightChild = z;
        }
    }

    /**
     * 插入数据方法，其中调用了插入节点方法
     * */
    public void insert(Item data) {
        BSTNode z = new BSTNode(data, null, null, null);
        insert(this, z);
    }

    /**
     * 打印整棵树方法
     * */
    private void print(BSTNode tree, Item data, int direction) {
        if (tree != null) {
            if (direction == 0)
                System.out.printf("%2d is root\n", tree.data);
            else
                System.out.printf("%2d is %2d's %6s child\n", tree.data, data, direction == 1 ? "right" : "left");
            print(tree.leftChild, tree.data, -1);
            print(tree.rightChild, tree.data, 1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.data, 0);
    }

    private void preOrder(BSTNode tree) {
        if(tree != null) {
            System.out.print(tree.data+" ");
            preOrder(tree.leftChild);
            preOrder(tree.rightChild);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    private void inOrder(BSTNode tree) {
        if(tree != null) {
            inOrder(tree.leftChild);
            System.out.print(tree.data+" ");
            inOrder(tree.rightChild);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    private void postOrder(BSTNode tree) {
        if(tree != null)
        {
            postOrder(tree.leftChild);
            postOrder(tree.rightChild);
            System.out.print(tree.data+" ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }
}
