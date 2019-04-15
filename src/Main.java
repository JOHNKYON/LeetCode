import questions.dataStructure.ListNode;
import questions.dataStructure.TreeNode;

import questions.leetcode10.RegularExpressionMatching;
import questions.leetcode1028.ConverttoBaseNeg2;
import questions.leetcode1030.NextGreaterNodeInLinkedList;
import questions.leetcode371.SumofTwoIntegers;
import questions.leetcode642.AutocompleteSystem;
import questions.weekly.Weekly;
import questions.weekly132.Solution;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        int[][] A = {{0,0,1}};


        int[] one_d_array = {3,3,3};
        int[] input2 = {3,5,7,9};

        int[][] two_d_array = {{0,4},{2, 8}};


        String[] strs  = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        char[][] pairs = {{'a', 'b'}, {'c', 'd'}};

        SumofTwoIntegers method= new SumofTwoIntegers();


        List<String> dict = new ArrayList<>();
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        n2.left = n1;
//        n2.right = n3;
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

//        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(1);
//        ListNode n3 = new ListNode(5);
//        n1.next = n2;
        method.getSum(2, 3);
//        System.out.print(method.input('i'));
;
    }

}
