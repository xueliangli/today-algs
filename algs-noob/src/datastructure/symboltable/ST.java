package datastructure.symboltable;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/*************************************************************************
 *  通过 TreeMap 实现符号表
 *
 *  Compilation:  javac ST.java
 *  Execution:    java ST
 *
 *  Sorted symbol table implementation using a java.util.TreeMap.
 *  Does not allow duplicates.
 *
 *  % java ST
 *
 *************************************************************************/
public class ST<Key extends Comparable<Key>,Value> implements Iterable<Key> {
    private TreeMap<Key,Value> st;
    public ST(){
        st = new TreeMap<>();
    }
    public void put(Key key,Value val){
        if (val==null) st.remove(key);
        else st.put(key,val);
    }
    /**
     * Return the value paired with given key; null if key is not in table.
     */
    public Value get(Key key) {
        return st.get(key);
    }

    /**
     * Delete the key (and paired value) from table.
     * Return the value paired with given key; null if key is not in table.
     */
    public Value delete(Key key) {
        return st.remove(key);
    }

    /**
     * Is the key in the table?
     */
    public boolean contains(Key key) {
        return st.containsKey(key);
    }

    /**
     * How many keys are in the table?
     */
    public int size() {
        return st.size();
    }

    /**
     * Return an <tt>Iterable</tt> for the keys in the table.
     * To iterate over all of the keys in the symbol table <tt>st</tt>, use the
     * foreach notation: <tt>for (Key key : st.keys())</tt>.
     */
    public Iterable<Key> keys() {
        return st.keySet();
    }

    /**
     * Return an <tt>Iterator</tt> for the keys in the table.
     * To iterate over all of the keys in the symbol table <tt>st</tt>, use the
     * foreach notation: <tt>for (Key key : st)</tt>.
     * This method is for backward compatibility with the version from <em>Introduction
     * to Programming in Java: An Interdisciplinary Approach.</em>
     */
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    /**
     * Return the smallest key in the table.
     */
    public Key min() {
        return st.firstKey();
    }

    /**
     * Return the largest key in the table.
     */
    public Key max() {
        return st.lastKey();
    }


    /**
     * Return the smallest key in the table >= k.
     */
    public Key ceil(Key k) {
        SortedMap<Key, Value> tail = st.tailMap(k);
        if (tail.isEmpty()) return null;
        else return tail.firstKey();
    }

    /**
     * Return the largest key in the table <= k.
     */
    public Key floor(Key k) {
        if (st.containsKey(k)) return k;
        // does not include key if present (!)
        SortedMap<Key, Value> head = st.headMap(k);
        if (head.isEmpty()) return null;
        else return head.lastKey();
    }
}
