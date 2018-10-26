

import questions.leetcode377.CombinationSumIV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] food = {{2,0},{0,0},{0,2},{2,2}};

        CombinationSumIV method= new CombinationSumIV();

        int[] input = {5,1,8};
        int[][] A = {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
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
        System.out.print(method.combinationSum4(input,24));
    }

}
