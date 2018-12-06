import edu.princeton.cs.algs4.StdIn;

import java.util.*;

public class TopM {
    /**
     * 商品信息类的实现
     */
    static class Transaction implements Comparable<Transaction> {
        //消费者,日期，金额
        private final String who;
        private final Date when;
        private final double amount;

        //构造器
        public Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        //创建一笔交易
        public Transaction(String transaction) {
            String[] a = transaction.split("\\s+");
            who = a[0];
            when = new Date(a[1]);
            amount = Double.parseDouble(a[2]);
        }

        public String who() {
            return who;
        }

        public Date when() {
            return when;
        }

        public double amount() {
            return amount;
        }

        public String toString() {
            return String.format("%-10s %10s %8.2f", who, when, amount);
        }

        //该交易和 that 进行比较
        public int compareTo(Transaction that) {
            if (this.amount < that.amount) return -1;
            else if (this.amount > that.amount) return +1;
            else return 0;
        }

        //该交易和 that 是否相同
        public boolean equals(Object x) {
            if (x == this) return true;
            if (x == null) return false;
            if (x.getClass() != this.getClass()) return false;
            Transaction that = (Transaction) x;
            return (this.amount == that.amount) && (this.who.equals(that.who))
                    && (this.when.equals(that.when));
        }

        //散列值
        public int hashCode() {
            int hash = 17;
            hash = 31 * hash + who.hashCode();
            hash = 31 * hash + when.hashCode();
            hash = 31 * hash + ((Double) amount).hashCode();
            return hash;
        }


        public static class WhoOrder implements Comparator<Transaction> {
            public int compare(Transaction v, Transaction w) {
                return v.who.compareTo(w.who);
            }
        }


        public static class WhenOrder implements Comparator<Transaction> {
            public int compare(Transaction v, Transaction w) {
                return v.when.compareTo(w.when);
            }
        }

        public static class HowMuchOrder implements Comparator<Transaction> {
            public int compare(Transaction v, Transaction w) {
                if (v.amount < w.amount) return -1;
                else if (v.amount > w.amount) return +1;
                else return 0;
            }
        }
    }

    /**
     * 优先队列的实现
     */
    public static class MinPQ<Key> implements Iterable<Key> {
        private Key[] pq;                    // store items at indices 1 to N
        private int N;                       // number of items on priority queue
        private Comparator<Key> comparator;  // optional comparator

        /**
         * Create an empty priority queue with the given initial capacity.
         */
        public MinPQ(int initCapacity) {
            pq = (Key[]) new Object[initCapacity + 1];
            N = 0;
        }

        /**
         * Create an empty priority queue.
         */
        public MinPQ() {
            this(1);
        }

        /**
         * Create an empty priority queue with the given initial capacity,
         * using the given comparator.
         */
        public MinPQ(int initCapacity, Comparator<Key> comparator) {
            this.comparator = comparator;
            pq = (Key[]) new Object[initCapacity + 1];
            N = 0;
        }

        /**
         * Create an empty priority queue using the given comparator.
         */
        public MinPQ(Comparator<Key> comparator) {
            this(1, comparator);
        }

        /**
         * Create a priority queue with the given items.
         * Takes time proportional to the number of items using sink-based heap construction.
         */
        public MinPQ(Key[] keys) {
            N = keys.length;
            pq = (Key[]) new Object[keys.length + 1];
            for (int i = 0; i < N; i++)
                pq[i + 1] = keys[i];
            for (int k = N / 2; k >= 1; k--)
                sink(k);
            assert isMinHeap();
        }

        /**
         * Is the priority queue empty?
         */
        public boolean isEmpty() {
            return N == 0;
        }

        /**
         * Return the number of items on the priority queue.
         */
        public int size() {
            return N;
        }

        /**
         * Return the smallest key on the priority queue.
         * Throw an exception if no such key exists because the priority queue is empty.
         */
        public Key min() {
            if (isEmpty()) throw new RuntimeException("Priority queue underflow");
            return pq[1];
        }

        // helper function to double the size of the heap array
        private void resize(int capacity) {
            assert capacity > N;
            Key[] temp = (Key[]) new Object[capacity];
            for (int i = 1; i <= N; i++) temp[i] = pq[i];
            pq = temp;
        }

        /**
         * Add a new key to the priority queue.
         */
        public void insert(Key x) {
            // double size of array if necessary
            if (N == pq.length - 1) resize(2 * pq.length);

            // add x, and percolate it up to maintain heap invariant
            pq[++N] = x;
            swim(N);
            assert isMinHeap();
        }

        /**
         * Delete and return the smallest key on the priority queue.
         * Throw an exception if no such key exists because the priority queue is empty.
         */
        public Key delMin() {
            if (N == 0) throw new RuntimeException("Priority queue underflow");
            exch(1, N);
            Key min = pq[N--];
            sink(1);
            pq[N + 1] = null;         // avoid loitering and help with garbage collection
            if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length / 2);
            assert isMinHeap();
            return min;
        }


        /***********************************************************************
         * Helper functions to restore the heap invariant.
         **********************************************************************/

        private void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k, k / 2);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && greater(j, j + 1)) j++;
                if (!greater(k, j)) break;
                exch(k, j);
                k = j;
            }
        }

        /***********************************************************************
         * Helper functions for compares and swaps.
         **********************************************************************/
        private boolean greater(int i, int j) {
            if (comparator == null) {
                return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
            } else {
                return comparator.compare(pq[i], pq[j]) > 0;
            }
        }

        private void exch(int i, int j) {
            Key swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
        }

        // is pq[1..N] a min heap?
        private boolean isMinHeap() {
            return isMinHeap(1);
        }

        // is subtree of pq[1..N] rooted at k a min heap?
        private boolean isMinHeap(int k) {
            if (k > N) return true;
            int left = 2 * k, right = 2 * k + 1;
            if (left <= N && greater(k, left)) return false;
            if (right <= N && greater(k, right)) return false;
            return isMinHeap(left) && isMinHeap(right);
        }


        /***********************************************************************
         * Iterators
         **********************************************************************/

        /**
         * Return an iterator that iterates over all of the keys on the priority queue
         * in ascending order.
         * <p>
         * The iterator doesn't implement <tt>remove()</tt> since it's optional.
         */
        public Iterator<Key> iterator() {
            return new HeapIterator();
        }

        private class HeapIterator implements Iterator<Key> {
            // create a new pq
            private MinPQ<Key> copy;

            // add all items to copy of heap
            // takes linear time since already in heap order so no keys move
            public HeapIterator() {
                if (comparator == null) copy = new MinPQ<Key>(size());
                else copy = new MinPQ<Key>(size(), comparator);
                for (int i = 1; i <= N; i++)
                    copy.insert(pq[i]);
            }

            public boolean hasNext() {
                return !copy.isEmpty();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Key next() {
                if (!hasNext()) throw new NoSuchElementException();
                return copy.delMin();
            }
        }

//        /**
//         * A test client.
//         */
//        public static void main(String[] args) {
//            MinPQ<String> pq = new MinPQ<String>();
//            while (!StdIn.isEmpty()) {
//                String item = StdIn.readString();
//                if (!item.equals("-")) pq.insert(item);
//                else if (!pq.isEmpty()) StdOut.print(pq.delMin() + " ");
//            }
//            StdOut.println("(" + pq.size() + " left on pq)");
//        }
    }

    /**
     * 利用优先队列打印出排序靠前的信息
     * 案例测试：
     */
    public static void main(String[] args) {
        //1、要保留的信息的条数
        int M = Integer.parseInt(args[0]);
        //2、创建优先队列的数据结构
        MinPQ<Transaction> pq = new MinPQ<>(M + 1);
        //3、一个循环，对输入的文本进行处理。a，结束条件：读到空行 b，将下一个元素放入循环队列中 c，进行判断，队列中个数大于要求就删除最小的
        while (StdIn.hasNextLine()) {
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M)
                pq.delMin();
        }
        //4、利用栈，将队列输出 a,创建一个栈 b，
        Stack<Transaction> stack = new Stack<>();
        while (!pq.isEmpty())
            stack.push(pq.delMin());
        for (Transaction t : stack) {
            StdOut.println(t);
        }
    }
}




