import questions.dataStructure.ListNode;
import questions.dataStructure.TreeNode;

import questions.leetcode449.SerializeandDeserializeBST;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        int[][] A = {{0,0,1}};

        SerializeandDeserializeBST method= new SerializeandDeserializeBST();

        int[] one_d_array = {1,3,0};
        int[] input2 = {3,5,7,9};

        int[][] two_d_array = {{1,0,0,0,1,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0},{0,1,1,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0},{1,0,0,0,1,0,0,0,0,0},{0,0,1,0,0,1,0,0,0,0},{0,0,0,0,0,0,1,0,0,1},{0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,1,0,0,1}};


        String[] strs  = {"acdb"};
        char[][] pairs = {{'a', 'b'}, {'c', 'd'}};
        List<String> dict = new ArrayList<>();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
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

        System.out.print(method.serialize(null));
        String data = method.serialize(null);
        method.deserialize(data);
    }

}
