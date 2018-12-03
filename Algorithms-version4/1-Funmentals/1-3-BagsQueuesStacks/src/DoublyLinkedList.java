import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {

    //1、三个成员变量：节点个数，头结点，尾节点
    private int N;
    private DoubleNode first;
    private DoubleNode last;

    //2、节点的嵌套类：？？？当前对象，数据域，前向指针，后向指针
    private class DoubleNode {
        private DoublyLinkedList<Item> parent = list();
        private Item item;
        private DoubleNode prev;
        private DoubleNode next;
    }

    //3、获取当前实例的方法
    private DoublyLinkedList<Item> list() {
        return this;
    }

    //4、构造方法：无参，参数为数据，参数为接口
    DoublyLinkedList() {
        first = null;
        last = null;
        N = 0;
    }

    public DoublyLinkedList(Item[] a) {
        for (Item t : a)
            append(t);
    }

    public DoublyLinkedList(Iterable<Item> coll) {
        for (Item t : coll)
            append(t);
    }

    //5、判断是否为空，判断元素个数
    boolean isEmpty() {
        return first == null;
    }

    private int size() {
        return N;
    }

    //6、返回第一个节点的数据，返回最后一个节点的数据
    private Item first() {
        if (isEmpty())
            throw new RuntimeException("List is empty");
        return first.item;
    }

    private Item last() {
        if (isEmpty())
            throw new RuntimeException("List is empty");
        return last.item;
    }

    //7、返回第k个节点
    public DoubleNode node(int k) {
        DoubleNode current = null;
        int i = 1;

        if (k > 0) {
            current = first;
            while (i < k && current != null) {
                current = current.next;
                i++;
            }
        } else if (k < 0) {
            k = -k;
            current = last;
            while (i < k && current != null) {
                current = current.prev;
                i++;
            }
        }
        return current;
    }

    //8、向前添加节点中的数据和向后添加节点中的数据
    void prepend(Item item) {
        DoubleNode x = new DoubleNode();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            x.next = first;
            first.prev = x;
            first = x;
        }
        N++;
    }

    public void append(Item item) {
        DoubleNode x = new DoubleNode();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            x.prev = last;
            last.next = x;
            last = x;
        }
        N++;
    }

    //9、向前插入节点和向后插入节点
    public void insertBefore(DoubleNode node, Item item) {
        if (node.parent != this)
            throw new RuntimeException("Node does not belong to list..");
        if (node == first)
            prepend(item);
        else {
            DoubleNode prev = node.prev;
            DoubleNode x = new DoubleNode();
            x.item = item;
            x.prev = prev;
            x.next = node;
            prev.next = x;
            node.prev = x;
            N++;
        }
    }

    public void insertAfter(DoubleNode node,Item item){
        if(node.parent!=this)
            throw new RuntimeException("Node does not belong to list..");
        if(node == last){
            append(item);
        }else{
            DoubleNode next =node.next;
            DoubleNode x=new DoubleNode();
            x.item=item;
            x.prev=node;
            x.next=next;
            next.prev=x;
            node.next=x;
            N++;
        }
    }
    //10、删除第一个和最后一个节点
    Item removeFirst(){
        if (isEmpty())
            throw new RuntimeException("List is empty");
        Item item = first.item;
        first.parent=null;
        if(first.next!=null)
            first.next.prev=null;
        first=first.next;
        N--;
        //?????????????
        if (first==null)
            last=null;
        return item;
    }

    Item removeLast(){
        if (isEmpty())
            throw new RuntimeException("List is empty");
        Item item = last.item;
        last.parent=null;
        if (last.prev!=null)
            last.prev.next=null;
        last=last.prev;
        N--;
        if (last==null)
            first=null;
        return item;
    }

    public Item remove(DoubleNode node){
        if (node.parent!=this)
            throw new RuntimeException("Node does not belong to List");
        if (node==first)
            return removeFirst();
        else if (node==last)
            return removeLast();
        else {
            node.parent =null;
            DoubleNode prev=node.prev;
            DoubleNode next=node.next;
            prev.next=node.next;
            next.prev=node.prev;
            N--;
            return node.item;
        }
    }
    //11、转化成字符串
    public String toString(){
        StringBuilder s=new StringBuilder();
        for(Item item:this)
            s.append(item).append(" ");
        return s.toString();
    }
    //12、增加迭代器遍历的功能
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private DoubleNode current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current=current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    //13、验证链表是否是正确的双链表
    private Iterable<Item> reversed() {
        return new ReverseIterable();
    }

    private class ReverseIterable implements Iterable<Item> {
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Item item : this)
                s.append(item).append(" ");
            return s.toString();
        }

        public Iterator<Item> iterator() {
            return new ReverseListIterator();
        }

        private class ReverseListIterator implements Iterator<Item> {
            private DoubleNode current = last;

            public boolean hasNext() {
                return current != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.prev;
                return item;
            }
        }
    }

    static void showList(DoublyLinkedList lst) {
        StdOut.println(lst);
        StdOut.println(lst.reversed() + "[in reverse]");
        if (!lst.isEmpty())
            StdOut.printf("Size: %d, First: %s, Last: %s\n\n", lst.size(), lst.first(), lst.last());
        else
            StdOut.printf("Size: %d\n\n", lst.size());
    }
}
