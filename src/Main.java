import questions.dataStructure.ArrayReader;
import questions.dataStructure.TreeNode;
import questions.leetcode126.WordLadderII;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        int[][] A = {{0,0,1}};

        WordLadderII method= new WordLadderII();

        int[] input = {-1,0,3,5,9,12};
        ArrayReader reader = new ArrayReader(input);

        int[][] B = {{0,0,0},
        {0,1,1},
            {0,0,1}};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        String[] strs  = {"hot","dot","dog","lot","log"};
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
        System.out.print(" ");
        System.out.print(method.findLadders("hit", "cog", dict));
    }

}
