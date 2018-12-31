import questions.dataStructure.Node;
import questions.dataStructure.TreeNode;
import questions.leetcode151.ReverseWordsinaString;
import questions.leetcode310.MinimumHeightTrees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        int[][] A = {{0,0,1}};

        ReverseWordsinaString method= new ReverseWordsinaString();

        int[] input = {1,2,5};
        int[] input2 = {3,5,7,9};

        int[][] two_d_array = {{0,1}, {0,2}, {0,3}, {3,4}, {4,5}};
        Node n1 = new Node(1, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        n1.next = n3;
        n3.next = n4;
        n4.next = n1;

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        String[] strs  = {"a", "bb", "acd", "ace"};
        String[][] pairs = {{"JFK","SFO"}};
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
        System.out.print(method.reverseWords("  i"));
    }

}
