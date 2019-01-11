import questions.dataStructure.ListNode;
import questions.dataStructure.Node;
import questions.dataStructure.TreeNode;

import questions.leetcode147.InsertionSortList;
import questions.leetcode924.MinimizeMalwareSpread;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        int[][] A = {{0,0,1}};

        InsertionSortList method= new InsertionSortList();

        int[] one_d_array = {1,3,0};
        int[] input2 = {3,5,7,9};

        int[][] two_d_array = {{1,0,0,0,1,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0},{0,1,1,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0},{1,0,0,0,1,0,0,0,0,0},{0,0,1,0,0,1,0,0,0,0},{0,0,0,0,0,0,1,0,0,1},{0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,1,0,0,1}};


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
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2; n2.next = n3; n3.next = n4;

        System.out.print(" ");
        System.out.print(method.insertionSortList(n1));
    }

}
