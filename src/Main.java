import questions.dataStructure.TreeNode;
import questions.leetcode329.LongestIncreasingPathInAMatrix;
import questions.leetcode474.OnesAndZeros;
import questions.leetcode638.ShoppingOffers;
import questions.leetcode813.LargestSumOfAverages;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] food = {{9,9,4},{6,6,8},{2,1,1}};

        LongestIncreasingPathInAMatrix method= new LongestIncreasingPathInAMatrix();

        int[] input = {1,2,3,4,5,6,7};
        int[][] A = {{1,3}};
        int[][] B = {{0,0,0},
        {0,1,1},
            {0,0,1}};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        String[] strs  = {"1", "1", "1"};
        List<Integer> a = new ArrayList<Integer>(){
            {
                add(2);
                add(5);
            }
        };
        List<Integer> b = new ArrayList<Integer>(){
            {
                add(3);
                add(2);
            }
        };
        List<Integer> c = new ArrayList<Integer>(){
            {
                add(3);
                add(0);
                add(5);
            }
        };
        List<Integer> d = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(10);
            }
        };
        List<List<Integer>> special = new ArrayList<>();
        special.add(c);
        special.add(d);
        System.out.print(method.longestIncreasingPath(food));
    }

}
