package datastructure.linkedlist;

/*************************************************************************
 *
 * 循环双向链表的实现：
 * 1、尾节点的前一个元素是之前的尾节点（头结点的前一个元素）
 * 2、当前尾节点的后一个元素为头结点
 *
 *************************************************************************/
public class DoubleLink<Item> {
    private DNode first;
    private int N;

    // 双向链表“节点”对应的结构体
    private class DNode {
        private DNode prev;
        private DNode next;
        private Item data;

        DNode(DNode prev, DNode next, Item data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    public DoubleLink() {
        first = new DNode(null, null, null);
        first.prev = first.next = first;
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // 获取第index位置的节点
    private DNode getNode(int index) {
        if (index < 0 || index >= N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //正向查找
        if (index <= N / 2) {
            DNode node = first.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        //反向查找
        DNode node = first.prev;
        for (int i = 0; i < N - index - 1; i++) {
            //此处注意前一个节点
            node = node.prev;
        }
        return node;
    }

    // 获取第index位置的节点的值
    public Item getData(int index) {
        return getNode(index).data;
    }

    public Item getFirstData() {
        return getNode(0).data;
    }

    public Item getLastData() {
        return getNode(N - 1).data;
    }

    // 将节点插入到第index位置之前
    public void insert(int index, Item data) {
        if (index == 0) {
            DNode node = new DNode(first, first.next, data);
            first.next.prev = node;
            first.next = node;
            N++;
            //这里的 return 不能少！！！！！！
            return;
        }
        DNode node = getNode(index);
        DNode cur = new DNode(node.prev, node, data);
        node.prev.next = cur;
        node.prev = cur;
        N++;
    }

    // 将节点追加到链表的末尾
    public void appendLast(Item data) {
        DNode cur = new DNode(first.prev, first, data);
        first.prev.next = cur;
        first.prev = cur;
        N++;
    }

    // 将节点插入第一个节点处
    public void insertFirst(Item data) {
        insert(0, data);
    }

    // 删除index位置的节点
    private void deleteNode(int index) {
        DNode node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        N--;
    }

    // 删除第一个节点
    public void deleteFirst() {
        deleteNode(0);
    }

    // 删除最后一个节点
    public void deleteLast() {
        deleteNode(N - 1);
    }
}
