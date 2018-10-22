import questions.codejam.ProductTriplets;
import questions.leetcode97.InterleavingString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] food = {{2,0},{0,0},{0,2},{2,2}};

        ProductTriplets method= new ProductTriplets();

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
        try {
            method.solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
