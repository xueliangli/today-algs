import data_structure.queue.MyQueue;
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
        int i, ilen;
//        String arr[] = {"A","B","C","D","E","F","G","H","I"};
        int[] arr={7,3,8,4,3,1,0,9,6};
        MyBSTree<Integer> tree = new MyBSTree<>();

        System.out.print("== 依次添加: ");
        ilen = arr.length;
        for(i=0; i<ilen; i++) {
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
}
