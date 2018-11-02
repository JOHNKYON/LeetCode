import questions.leetcode256.PaintHouse;
import questions.leetcode410.SplitArrayLargestSum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] food = {{17, 2, 17},{16,16,5},{14,3,19}};

        SplitArrayLargestSum method= new SplitArrayLargestSum();

        int[] input = {1,2,3,4,5};
        int[][] A = {{1,1,1,1,1,0},{0,0,0,0,0,1},{0,1,1,0,0,1},{1,0,0,1,0,1},{1,0,1,0,0,1},{1,0,0,0,0,1},{0,1,1,1,1,0}};
        int[][] B = {{0,0,0},
        {0,1,1},
            {0,0,1}};
        String[] strs  = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        List<String> d = new ArrayList<String>(){
            {
//                add("a");
//                add("b");
//                add("c");
            }
        };
        System.out.print(method.splitArray2(input, 2));
    }

}
