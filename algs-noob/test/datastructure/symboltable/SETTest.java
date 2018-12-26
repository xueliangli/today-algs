package datastructure.symboltable;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class SETTest {
    @Test
    public void testSET(){
        SET<String> set = new SET<>();
        // insert some keys
        set.add("www.cs.princeton.edu");
        set.add("www.cs.princeton.edu");    // overwrite old value
        set.add("www.princeton.edu");
        set.add("www.math.princeton.edu");
        set.add("www.yale.edu");
        set.add("www.amazon.com");
        set.add("www.simpsons.com");
        set.add("www.stanford.edu");
        set.add("www.google.com");
        set.add("www.ibm.com");
        set.add("www.apple.com");
        set.add("www.slashdot.com");
        set.add("www.whitehouse.gov");
        set.add("www.espn.com");
        set.add("www.snopes.com");
        set.add("www.movies.com");
        set.add("www.cnn.com");
        set.add("www.iitb.ac.in");


        StdOut.println(set.contains("www.cs.princeton.edu"));
        StdOut.println(!set.contains("www.harvardsucks.com"));
        StdOut.println(set.contains("www.simpsons.com"));
        StdOut.println();

        StdOut.println("ceil(www.simpsonr.com) = " + set.ceil("www.simpsonr.com"));
        StdOut.println("ceil(www.simpsons.com) = " + set.ceil("www.simpsons.com"));
        StdOut.println("ceil(www.simpsont.com) = " + set.ceil("www.simpsont.com"));
        StdOut.println("floor(www.simpsonr.com) = " + set.floor("www.simpsonr.com"));
        StdOut.println("floor(www.simpsons.com) = " + set.floor("www.simpsons.com"));
        StdOut.println("floor(www.simpsont.com) = " + set.floor("www.simpsont.com"));
        StdOut.println();


        // print out all keys in the set in lexicographic order
        for (String s : set) {
            StdOut.println(s);
        }
    }
}
