import questions.leetcode256.PaintHouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] food = {{17, 2, 17},{16,16,5},{14,3,19}};

        PaintHouse method= new PaintHouse();

        int[] input = {1, 3, 2, 8, 4, 9};
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
        System.out.print(method.minCost(food));
    }

}
