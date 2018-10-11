import questions.leetcode524.LongestWordinDictionaryThroughDeleting;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        LongestWordinDictionaryThroughDeleting method= new LongestWordinDictionaryThroughDeleting();

        int[] input = {7,6,4,3,1};
        int[][] hits = {{1,0}, {0,0}, {2,0}};
        String[] strs  = {"a","b","c"};
        List<String> d = new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        };

        System.out.print(method.findLongestWord("abc", d));
//        method.next(1);
//        method.next(10);
//        method.next(3);
//        method.next(5);
    }

}
