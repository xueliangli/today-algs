package datastructure.tree;


import org.junit.Test;

/**
 * 关于自平衡二叉树的测试
 */
public class AVLTreeTest {
    @Test
    public void testMyAVLTree() {
        int arr[] = {3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};

        int i;
        AVLTree<Integer> tree = new AVLTree<>();

        System.out.print("== 依次添加: ");
        for (i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }

        System.out.print("\n== 前序遍历: ");
        tree.preOrder();

        System.out.print("\n== 中序遍历: ");
        tree.inOrder();

        System.out.print("\n== 后序遍历: ");
        tree.postOrder();
        System.out.print("\n");

        System.out.printf("== 高度: %d\n", tree.height());
        System.out.printf("== 最小值: %d\n", tree.minimum());
        System.out.printf("== 最大值: %d\n", tree.maximum());
        System.out.print("== 树的详细信息: \n");
        tree.print();

        i = 8;
        System.out.printf("\n== 删除根节点: %d", i);
        tree.remove(i);

        System.out.printf("\n== 高度: %d", tree.height());
        System.out.print("\n== 中序遍历: ");
        tree.inOrder();
        System.out.print("\n== 树的详细信息: \n");
        tree.print();
        // 销毁二叉树
        tree.destroy();
    }
}
