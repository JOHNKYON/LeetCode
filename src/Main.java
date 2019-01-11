import questions.dataStructure.Node;
import questions.dataStructure.TreeNode;

import questions.leetcode16.ThreeSumClosest;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        int[][] A = {{0,0,1}};

        ThreeSumClosest method= new ThreeSumClosest();

        int[] input = {1,2,5,10, 11};
        int[] input2 = {3,5,7,9};

        int[][] two_d_array = {{0,1}, {0,2}, {0,3}, {3,4}, {4,5}};


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

        System.out.print(" ");
        System.out.print(method.threeSumClosest(input, 12));
    }

}
