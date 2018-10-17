import questions.leetcode97.InterleavingString;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        int[][] food = {{2,0},{0,0},{0,2},{2,2}};

        InterleavingString method= new InterleavingString();

        int[] input = {1,2,3,8,9,10};
        int[][] A = {{1,1,0},
        {0,1,0},
            {0,1,0}};
        int[][] B = {{0,0,0},
        {0,1,1},
            {0,0,1}};
        String[] strs  = {"hello", "hi", "helo"};
        List<String> d = new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        };
        System.out.print(method.isInterleave("aabcc",
                "dbbca",
                "aadbbcbcac"
        ));
    }

}
