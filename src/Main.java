import questions.codejam.ProductTriplets;
import questions.leetcode659.SplitArrayintoConsecutiveSubsequences;
import questions.leetcode97.InterleavingString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] food = {{2,0},{0,0},{0,2},{2,2}};

        SplitArrayintoConsecutiveSubsequences method= new SplitArrayintoConsecutiveSubsequences();

        int[] input = {1,2,3,3,4,5};
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
            method.isPossible(input);
    }

}
