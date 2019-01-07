package algs.search;

import org.junit.Test;

import static algs.search.TreeSearch.medOrderLoop;
import static algs.search.TreeSearch.medOrderRecursion;

/**
 * @program: algs-noob
 * @description: 测试二叉查找树算法
 * @author: 李学亮
 * @create: 2019-01-07 10:45
 **/
public class TreeSearchTest {
    @Test
    public void testTreeSearch(){
        TreeSearch tree = new TreeSearch();
        tree.addTreeNode(50);
        tree.addTreeNode(80);
        tree.addTreeNode(20);
        tree.addTreeNode(60);
        tree.addTreeNode(10);
        tree.addTreeNode(30);
        tree.addTreeNode(70);
        tree.addTreeNode(90);
        tree.addTreeNode(100);
        tree.addTreeNode(40);
        System.out.println("==============================" + "采用递归的中序遍历开始" + "==============================");
        medOrderRecursion(tree.root);
        System.out.println();
        System.out.println("==============================" + "采用循环的中序遍历开始" + "==============================");
        medOrderLoop(tree.root);
        System.out.println();
    }
}
