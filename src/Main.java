import questions.dataStructure.ListNode;
import questions.dataStructure.TreeNode;


import questions.leetcode1094.CarPooling;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        int[][] A = {{2,1,5}, {3,3,7}};


//        int[] one_d_array = {31,26,33,21,40};
        int[] one_d_array = {1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98};
        int[] input2 = {3,5,7,9};

        int[][] two_d_array = {};


        String[] strs  = {"qyssedya","pabouk","mjwdrbqwp","vylodpmwp","nfyqeowa","pu","paboukc","qssedya","lopmw","nfyqowa","vlodpmw","mwdrqwp","opmw","qsda","neo","qyssedhyac","pmw","lodpmw","mjwdrqwp","eo","nfqwa","pabuk","nfyqwa","qssdya","qsdya","qyssedhya","pabu","nqwa","pabqoukc","pbu","mw","vlodpmwp","x","xr"};
        char[][] pairs = {{'a', 'b'}, {'c', 'd'}};

        CarPooling method= new CarPooling();


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
        System.out.println(method.carPooling(A, 4));
//        System.out.print(method.input('i'));
;
    }

}
