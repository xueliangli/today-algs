import org.junit.Test;

public class DoublyLinkedListTest {
    /**
     *
     * prepend:
     * 10 8 6 4 2
     * 2 4 6 8 10 [in reverse]
     * Size: 5, First: 10, Last: 2
     *
     * */
    @Test
    public  void testPrepend() {
        StdOut.println("prepend:");

        int[] a = {2, 4, 6, 8, 10};
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<>();

        for (int anA : a) lst.prepend(anA);
        DoublyLinkedList.showList(lst);
        StdOut.println();
    }


    /**
     * append:
     * 2 4 6 8 10
     * 10 8 6 4 2 [in reverse]
     * Size: 5, First: 2, Last: 10
     *
     * */
    @Test
    public void testAppend() {
        StdOut.println("append:");

        int[] a = {2, 4, 6, 8, 10};
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<>();

        for (int anA : a) lst.append(anA);
        DoublyLinkedList.showList(lst);
        StdOut.println();
    }

    /**
     * removeFirst:
     * 6 8 12 [initial]
     *
     * removeFirst(): 6
     * 8 12
     * 12 8 [in reverse]
     * Size: 2, First: 8, Last: 12
     *
     * removeFirst(): 8
     * 12
     * 12 [in reverse]
     * Size: 1, First: 12, Last: 12
     *
     * removeFirst(): 12
     *
     * [in reverse]
     * Size: 0
     * */
    @Test
    public void testRemoveFirst() {
        StdOut.println("removeFirst:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<>(new Integer[]{6, 8, 12});
        StdOut.println(lst + "[initial]\n");

        while (!lst.isEmpty()) {
            StdOut.println("removeFirst(): " + lst.removeFirst());
            DoublyLinkedList.showList(lst);
        }
        StdOut.println();
    }

    /**
     * removeLast:
     * 6 8 12 [initial]
     *
     * removeLast(): 12
     * 6 8
     * 8 6 [in reverse]
     * Size: 2, First: 6, Last: 8
     *
     * removeLast(): 8
     * 6
     * 6 [in reverse]
     * Size: 1, First: 6, Last: 6
     *
     * removeLast(): 6
     *
     * [in reverse]
     * Size: 0
     * */
    @Test
    public void testRemoveLast() {
        StdOut.println("removeLast:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<>(new Integer[]{6, 8, 12});
        StdOut.println(lst + "[initial]\n");

        while (!lst.isEmpty()) {
            StdOut.println("removeLast(): " + lst.removeLast());
            DoublyLinkedList.showList(lst);
        }
        StdOut.println();
    }

    /**
     * remove:
     * 2 4 6 8 [initial]
     *
     * remove(node(2)): 4
     * 2 6 8
     * 8 6 2 [in reverse]
     * Size: 3, First: 2, Last: 8
     *
     * remove(node(-1)): 8
     * 2 6
     * 6 2 [in reverse]
     * Size: 2, First: 2, Last: 6
     *
     * remove(node(1)): 2
     * 6
     * 6 [in reverse]
     * Size: 1, First: 6, Last: 6
     *
     * remove(node(1)): 6
     *
     * [in reverse]
     * Size: 0
     * */
    @Test
    public void testRemove() {
        StdOut.println("remove:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<>(new Integer[]{2, 4, 6, 8});
        StdOut.println(lst + "[initial]\n");

        int[] k = {2, -1, 1, 1};

        for (int aK : k) {
            StdOut.printf("remove(node(%d)): %d\n", aK, lst.remove(lst.node(aK)));
            DoublyLinkedList.showList(lst);
        }
        StdOut.println();
    }

    /**
     *insertBefore:
     * 2 4 6 8 [initial]
     *
     * insertBefore(node(3), 10):
     * 2 4 10 6 8
     * 8 6 10 4 2 [in reverse]
     * Size: 5, First: 2, Last: 8
     *
     * insertBefore(node(2), 12):
     * 2 12 4 10 6 8
     * 8 6 10 4 12 2 [in reverse]
     * Size: 6, First: 2, Last: 8
     *
     * insertBefore(node(1), 14):
     * 14 2 12 4 10 6 8
     * 8 6 10 4 12 2 14 [in reverse]
     * Size: 7, First: 14, Last: 8
     *
     * insertBefore(node(-1), 16):
     * 14 2 12 4 10 6 16 8
     * 8 16 6 10 4 12 2 14 [in reverse]
     * Size: 8, First: 14, Last: 8
     * */
    @Test
    public void testInsertBefore() {
        StdOut.println("insertBefore:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<>(new Integer[]{2, 4, 6, 8});
        StdOut.println(lst + "[initial]\n");

        int[] k = {3, 2, 1, -1},
                x = {10, 12, 14, 16};

        for (int i = 0; i < k.length; i++) {
            StdOut.printf("insertBefore(node(%d), %d):\n", k[i], x[i]);
            lst.insertBefore(lst.node(k[i]), x[i]);
            DoublyLinkedList.showList(lst);
        }
        StdOut.println();
    }

    /**
     * insertAfter:
     * 1 3 5 7 [initial]
     *
     * insertAfter(node(2), 9):
     * 1 3 9 5 7
     * 7 5 9 3 1 [in reverse]
     * Size: 5, First: 1, Last: 7
     *
     * insertAfter(node(-2), 11):
     * 1 3 9 5 11 7
     * 7 11 5 9 3 1 [in reverse]
     * Size: 6, First: 1, Last: 7
     *
     * insertAfter(node(-1), 13):
     * 1 3 9 5 11 7 13
     * 13 7 11 5 9 3 1 [in reverse]
     * Size: 7, First: 1, Last: 13
     *
     * insertAfter(node(1), 15):
     * 1 15 3 9 5 11 7 13
     * 13 7 11 5 9 3 15 1 [in reverse]
     * Size: 8, First: 1, Last: 13
     * */
    @Test
    public void testInsertAfter() {
        StdOut.println("insertAfter:");
        DoublyLinkedList<Integer> lst = new DoublyLinkedList<>(new Integer[]{1, 3, 5, 7});
        StdOut.println(lst + "[initial]\n");

        int[] k = {2, -2, -1, 1},
                x = {9, 11, 13, 15};

        for (int i = 0; i < k.length; i++) {
            StdOut.printf("insertAfter(node(%d), %d):\n", k[i], x[i]);
            lst.insertAfter(lst.node(k[i]), x[i]);
            DoublyLinkedList.showList(lst);
        }
        StdOut.println();
    }
}
