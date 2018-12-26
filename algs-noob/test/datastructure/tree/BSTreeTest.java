package datastructure.tree;

import datastructure.tree.BSTree;
import org.junit.Test;

/**
 * 关于二叉树的测试
 */
public class BSTreeTest {
    @Test
    public void testMyBSTree() {
        int i, len;
        int[] arr = {7, 3, 8, 4, 3, 1, 0, 9, 6};
        BSTree<Integer> tree = new BSTree<>();

        System.out.print("== 依次添加: ");
        len = arr.length;
        for (i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
            tree.insert(arr[i]);
        }
        System.out.println("\n== 二叉树结构为: ");
        tree.print();

        System.out.print("\n== 前序遍历: ");
        tree.preOrder();

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();

        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
    }
}
