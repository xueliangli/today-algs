package datastructure.symboltable;


/**
 * @program: algs-noob
 * @description: 基于无序链表的符号表实现
 * @author: 李学亮    emil: 18222027300@163.com
 * @create: 2019-01-09 21:43
 **/
public class SequentialSearchST<Key, Value> {
    private Node first;

    /**
     * @description: 内部类，链表的结点
     * @param:
     * @return:
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 21:47
     */
    private class Node {
        private Key key;
        private Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * @description: 通过键得到值
     * @param: [key]
     * @return: Value
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 21:51
     */
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }

        }
        return null;
    }

    /**
     * @description: 查找给定的值，找到则更新其值，否则在表中创建新节点
     * @param: [key, value]
     * @return: void
     * @author: 李学亮
     * @date: 2019/1/9
     * @time: 21:57
     */
    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        //当键不存在时，创建一个新键
        first = new Node(key, value, first);
    }
}
