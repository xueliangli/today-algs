package datastructure.symboltable;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class STTest {
    @Test
    public void testST(){
        ST<String, String> st = new ST<String, String>();

        // insert some key-value pairs
        st.put("www.cs.princeton.edu",   "128.112.136.11");
        st.put("www.cs.princeton.edu",   "128.112.136.35");    // overwrite old value
        st.put("www.princeton.edu",      "128.112.130.211");
        st.put("www.math.princeton.edu", "128.112.18.11");
        st.put("www.yale.edu",           "130.132.51.8");
        st.put("www.amazon.com",         "207.171.163.90");
        st.put("www.simpsons.com",       "209.123.16.34");
        st.put("www.stanford.edu",       "171.67.16.120");
        st.put("www.google.com",         "64.233.161.99");
        st.put("www.ibm.com",            "129.42.16.99");
        st.put("www.apple.com",          "17.254.0.91");
        st.put("www.slashdot.com",       "66.35.250.150");
        st.put("www.whitehouse.gov",     "204.153.49.136");
        st.put("www.espn.com",           "199.181.132.250");
        st.put("www.snopes.com",         "66.165.133.65");
        st.put("www.movies.com",         "199.181.132.250");
        st.put("www.cnn.com",            "64.236.16.20");
        st.put("www.iitb.ac.in",         "202.68.145.210");


        StdOut.println(st.get("www.cs.princeton.edu"));
        StdOut.println(st.get("www.harvardsucks.com"));
        StdOut.println(st.get("www.simpsons.com"));
        StdOut.println();

        StdOut.println("ceil(www.simpsonr.com) = " + st.ceil("www.simpsonr.com"));
        StdOut.println("ceil(www.simpsons.com) = " + st.ceil("www.simpsons.com"));
        StdOut.println("ceil(www.simpsont.com) = " + st.ceil("www.simpsont.com"));
        StdOut.println("floor(www.simpsonr.com) = " + st.floor("www.simpsonr.com"));
        StdOut.println("floor(www.simpsons.com) = " + st.floor("www.simpsons.com"));
        StdOut.println("floor(www.simpsont.com) = " + st.floor("www.simpsont.com"));

        StdOut.println();

        StdOut.println("min key: " + st.min());
        StdOut.println("max key: " + st.max());
        StdOut.println("size:    " + st.size());
        StdOut.println();

        // print out all key-value pairs in lexicographic order
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
