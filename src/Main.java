import questions.leetcode930.BinarySubarraysWithSum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] food = {{2,0},{0,0},{0,2},{2,2}};

        BinarySubarraysWithSum method= new BinarySubarraysWithSum();

        int[] input = {0,0,0,0,0};
        int[][] A = {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
        int[][] B = {{0,0,0},
        {0,1,1},
            {0,0,1}};
        String[] strs  = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        List<String> d = new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        };
        System.out.print(method.numSubarraysWithSum(input,0));
    }

}
