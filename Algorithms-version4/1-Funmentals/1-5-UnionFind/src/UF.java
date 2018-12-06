import edu.princeton.cs.algs4.StdIn;

public class UF {
    private int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components

    /**
     * Create an empty union find data structure with N isolated sets.
     */
    private UF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * Return the id of component corresponding to object p.
     */
    private int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    /**
     * Return the number of disjoint sets.
     */
    private int count() {
        return count;
    }


    /**
     * Are objects p and q in the same set?
     */
    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     * Replace sets containing p and q with their union.
     */
    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make smaller root point to larger one
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        //用这个方法需要在控制台输入，并且
//        System.out.println("请输入数字对：\n");
        int N = StdIn.readInt();
        UF uf = new UF(N);

        // read in a sequence of pairs of integers (each in the range 0 to N-1),
        // calling find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
//        for (int i = 1; i < N; i++) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            if (uf.connected(p, q)) continue;
//            uf.union(p, q);
//            StdOut.println(p + " " + q);
//        }

        //这种循环总是不输出最后一行
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }

        StdOut.println("# components: " + uf.count());
    }
}
