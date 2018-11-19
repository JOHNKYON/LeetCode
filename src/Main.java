import questions.codejam.roundH2018.BigButtons;
import questions.dataStructure.TreeNode;
import questions.leetcode127.WordLadder;
import questions.leetcode467.UniqueSubstringsInWraparoudString;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        int[][] food = {{9,9,4},{6,6,8},{2,1,1}};

        int[][] A = {{9,10},{9,10},{4,5},{-9,-3},{-9,1},{0,3},{6,10},{-5,-4},{-7,-6}};

        WordLadder method= new WordLadder();

        int[] input = {-2147483648,0,-2147483648};
        int[][] B = {{0,0,0},
        {0,1,1},
            {0,0,1}};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        String[] strs  = {"hot","dot","dog","lot","log","cog"};
        List<String> dict = new ArrayList<>();
        for (String str: strs)
            dict.add(str);
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
        System.out.print(method.ladderLength("hit", "cog", dict));
    }

}
