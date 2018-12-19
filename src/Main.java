import questions.dataStructure.Node;
import questions.dataStructure.TreeNode;
import questions.leetcode773.SlidingPuzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        int[][] A = {{0,0,1}};

        SlidingPuzzle method= new SlidingPuzzle();

        int[] input = {0,2,4,6,7,1,3,5};
        int[] input2 = {3,5,7,9};

        int[][] B = {{4,1,2}, {5,0,3}};
        Node n1 = new Node(1, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        n1.next = n3;
        n3.next = n4;
        n4.next = n1;

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        String[] strs  = {"hot","dot","dog","lot","log"};
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
        System.out.print(" ");
        System.out.print(method.slidingPuzzle(B));
    }

}
