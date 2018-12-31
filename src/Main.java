import questions.dataStructure.Node;
import questions.dataStructure.TreeNode;
import questions.dataStructure.ListNode;
import questions.leetcode25.ReverseNodesInKGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        int[][] A = {{0,0,1}};

        ReverseNodesInKGroup method= new ReverseNodesInKGroup();

        int[] input = {1,2,5};
        int[] input2 = {3,5,7,9};

        int[][] two_d_array = {{0,1}, {0,2}, {0,3}, {3,4}, {4,5}};

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

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
        System.out.print(method.reverseKGroup(n1, 2));
    }

}
