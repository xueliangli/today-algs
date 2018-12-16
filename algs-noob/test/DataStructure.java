import data_structure.queue.MyQueue;
import data_structure.tree.MyAVLTree;
import data_structure.tree.MyBSTree;
import org.junit.Test;

public class DataStructure {
    @Test
    public void testMyQueue(){
        MyQueue<Integer> ints = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            ints.enqueue(i);
        }
        ints.displayList();
    }

    @Test
    public void testMyBSTree(){
        int i, len;
        int[] arr={7,3,8,4,3,1,0,9,6};
        MyBSTree<Integer> tree = new MyBSTree<>();

        System.out.print("== 依次添加: ");
        len = arr.length;
        for(i=0; i<len; i++) {
            System.out.print(arr[i]+" ");
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

    @Test
    public void testMyAVLTree(){
        int arr[]= {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};

        int i;
        MyAVLTree<Integer> tree = new MyAVLTree<>();

        System.out.print("== 依次添加: ");
        for(i=0; i<arr.length; i++) {
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
