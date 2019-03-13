package algs.search;

import java.util.Stack;

/**
 * @program: algs-noob
 * @description: 二叉排序树（BST树）
 * @author: 李学亮
 * @create: 2019-01-07 10:00
 **/
public class TreeSearch {
    public TreeNode root;
    private int size;

    /**
     * @Description:内部类，树的节点
     * @Author: 李学亮
     * @Date: 2019/1/7
     */
    private class TreeNode<T> {
        private Integer data;
        private TreeNode parent;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Integer data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }

    /**
     * @Description:向树中插入数据
     * @Param: [data]
     * @return: java.lang.Boolean
     * @Author: 李学亮
     * @Date: 2019/1/7
     */
    public void addTreeNode(Integer data) {
        if (null == root) {
            root = new TreeNode(data);
            System.out.println("插入成功");
            return;
        }

        TreeNode<Integer> treeNode = new TreeNode<>(data);
        TreeNode<Integer> currentNode = root;
        TreeNode<Integer> parentNode;
        while (true) {
            parentNode = currentNode;
            if (currentNode.data < data) {
                currentNode = currentNode.right;
                if (null == currentNode) {
                    parentNode.right = treeNode;
                    treeNode.parent = parentNode;
                    System.out.println("插入成功");
                    size++;
                    return;
                }
            } else if (currentNode.data > data) {
                currentNode = currentNode.left;
                if (null == currentNode) {
                    parentNode.left = treeNode;
                    treeNode.parent = parentNode;
                    System.out.println("插入成功");
                    size++;
                    return;
                }
            } else {
                System.out.println("插入节点相同");
                return;
            }
        }
    }

    /**
     * @Description: 查找树中是否含有相应节点
     * @Param: [data]
     * @return: algs.search.TreeSearch.TreeNode
     * @Author: 李学亮
     * @Date: 2019/1/7
     */
    public TreeNode findTreeNode(Integer data) {
        if (null == root) {
            return null;
        }
        TreeNode current = root;
        while (current != null) {
            if (current.data > data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    /**
     * @Description: 中序遍历的递归实现, 规则：左---根---右
     * @Param: [treeNode]
     * @return: void
     * @Author: 李学亮
     * @Date: 2019/1/7
     */
    public static void medOrderRecursion(TreeNode treeNode) {
        if (null != treeNode) {
            if (null != treeNode.left) {
                medOrderRecursion(treeNode.left);
            }
            System.out.print(treeNode.data + "  ");
            if (null != treeNode.right) {
                medOrderRecursion(treeNode.right);
            }
        }
    }

    /**
     * @Description: 循环实现中序遍历
     * @Param: [treeNode]
     * @return: void
     * @Author: 李学亮
     * @Date: 2019/1/7
     */
    public static void medOrderLoop(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = treeNode;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.data + "  ");
                current = current.right;
            }
        }
    }
}
