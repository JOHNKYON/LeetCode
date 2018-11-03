import questions.dataStructure.TreeNode;
import questions.leetcode376.WiggleSubsequence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] food = {{17, 2, 17},{16,16,5},{14,3,19}};

        WiggleSubsequence method= new WiggleSubsequence();

        int[] input = {1,1};
        int[][] A = {{1,3}};
        int[][] B = {{0,0,0},
        {0,1,1},
            {0,0,1}};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        String[] strs  = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        List<String> d = new ArrayList<String>(){
            {
//                add("a");
//                add("b");
//                add("c");
            }
        };
        System.out.print(method.wiggleMaxLength(input));
    }

}
