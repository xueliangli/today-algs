package datastructure.symboltable;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
/*************************************************************************
 *
 *  通过 Set 实现符号表
 *
 *************************************************************************/
public class SET<Key extends Comparable<Key>> implements Iterable<Key> {
    private TreeSet<Key> set;

    public SET() {
        set = new TreeSet<>();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Add the key to this set.
     */
    public void add(Key key) {
        set.add(key);
    }

    /**
     * Does this set contain the given key?
     */
    public boolean contains(Key key) {
        return set.contains(key);
    }

    /**
     * Delete the given key from this set.
     */
    public void delete(Key key) {
        set.remove(key);
    }

    /**
     * Return the number of keys in this set.
     */
    public int size() {
        return set.size();
    }

    /**
     * Return an Iterator for this set.
     */
    public Iterator<Key> iterator() {
        return set.iterator();
    }

    /**
     * Return the key in this set with the maximum value.
     */
    public Key max() {
        return set.last();
    }

    /**
     * Return the key in this set with the minimum value.
     */
    public Key min() {
        return set.first();
    }

    /**
     * Return the smallest key in this set >= k.
     */
    public Key ceil(Key k) {
        SortedSet<Key> tail = set.tailSet(k);
        if (tail.isEmpty()) return null;
        else return tail.first();
    }

    /**
     * Return the largest key in this set <= k.
     */
    public Key floor(Key k) {
        if (set.contains(k)) return k;

        // does not include key if present (!)
        SortedSet<Key> head = set.headSet(k);
        if (head.isEmpty()) return null;
        else return head.last();
    }

    /**
     * Return the union of this set with that set.
     */
    public SET<Key> union(SET<Key> that) {
        SET<Key> c = new SET<>();
        for (Key x : this) {
            c.add(x);
        }
        for (Key x : that) {
            c.add(x);
        }
        return c;
    }

    /**
     * Return the intersection of this set with that set.
     */
    public SET<Key> intersect(SET<Key> that) {
        SET<Key> c = new SET<>();
        if (this.size() < that.size()) {
            for (Key x : this) {
                if (that.contains(x)) c.add(x);
            }
        }
        else {
            for (Key x : that) {
                if (this.contains(x)) c.add(x);
            }
        }
        return c;
    }

    /**
     * Does this SET equal that set.
     */
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        SET<Key> that = (SET<Key>) y;
        if (this.size() != that.size()) return false;
        try {
            for (Key k : this)
                if (!that.contains(k)) return false;
        } catch (ClassCastException exception) {
            return false;
        }
        return true;
    }
}
