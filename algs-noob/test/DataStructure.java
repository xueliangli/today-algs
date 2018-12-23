import data_structure.domain.Student;
import data_structure.linked_list.DoubleLink;
import data_structure.queue.Queue;
import data_structure.tree.AVLTree;
import data_structure.tree.BSTree;
import org.junit.Test;

public class DataStructure {
    /**
     *
     * 关于双向链表的测试
     *
     * */
    @Test
    public void testDoubleLink(){
        int[] arr = {10, 20, 30, 40};

        System.out.println("\n----int_test----");
        // 创建双向链表
        DoubleLink<Integer> integerDoubleLink = new DoubleLink<>();

        integerDoubleLink.insert(0, arr[1]);    // 将 20 插入到第一个位置
        integerDoubleLink.appendLast(arr[0]);    // 将 10 追加到链表末尾
        integerDoubleLink.insertFirst(arr[2]);    // 将 30 插入到第一个位置

        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", integerDoubleLink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", integerDoubleLink.size());

        // 打印出全部的节点
        for (int i=0; i<integerDoubleLink.size(); i++)
            System.out.println("integerDoubleLink("+i+")="+ integerDoubleLink.getData(i));
        //=================================================================================
        String[] sarr = {"ten", "twenty", "thirty", "forty"};

        System.out.println("\n----string_test----");
        // 创建双向链表
        DoubleLink<String> stringDoubleLink = new DoubleLink<>();

        stringDoubleLink.insert(0, sarr[1]);    // 将 sarr中第2个元素 插入到第一个位置
        stringDoubleLink.appendLast(sarr[0]);    // 将 sarr中第1个元素 追加到链表末尾
        stringDoubleLink.insertFirst(sarr[2]);    // 将 sarr中第3个元素 插入到第一个位置

        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", stringDoubleLink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", stringDoubleLink.size());

        // 打印出全部的节点
        for (int i=0; i<stringDoubleLink.size(); i++)
            System.out.println("stringDoubleLink("+i+")="+ stringDoubleLink.getData(i));
        //=================================================================================
        Student[] students = new Student[]{
                new Student(10, "sky"),
                new Student(20, "jody"),
                new Student(30, "vic"),
                new Student(40, "dan"),
        };
        System.out.println("\n----object_test----");
        // 创建双向链表
        DoubleLink<Student> studentDoubleLink = new DoubleLink<>();

        studentDoubleLink.insert(0, students[1]);    // 将 students中第2个元素 插入到第一个位置
        studentDoubleLink.appendLast(students[0]);    // 将 students中第1个元素 追加到链表末尾
        studentDoubleLink.insertFirst(students[2]);    // 将 students中第3个元素 插入到第一个位置

        // 双向链表是否为空
        System.out.printf("isEmpty()=%b\n", studentDoubleLink.isEmpty());
        // 双向链表的大小
        System.out.printf("size()=%d\n", studentDoubleLink.size());

        // 打印出全部的节点
        for (int i=0; i<studentDoubleLink.size(); i++) {
            System.out.println("studentDoubleLink("+i+")="+ studentDoubleLink.getData(i));
        }
    }

    /**
     *
     * 关于队列的测试
     *
     * */
    @Test
    public void testMyQueue(){
        Queue<Integer> ints = new Queue<>();
        for (int i = 0; i < 10; i++) {
            ints.enqueue(i);
        }
        ints.displayList();
    }

    /**
     *
     * 关于二叉树的测试
     *
     * */
    @Test
    public void testMyBSTree(){
        int i, len;
        int[] arr={7,3,8,4,3,1,0,9,6};
        BSTree<Integer> tree = new BSTree<>();

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

    /**
     *
     * 关于自平衡二叉树的测试
     *
     * */
    @Test
    public void testMyAVLTree(){
        int arr[]= {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};

        int i;
        AVLTree<Integer> tree = new AVLTree<>();

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
