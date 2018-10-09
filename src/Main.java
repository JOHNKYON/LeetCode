import questions.leetcode447.NumberofBoomerangs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        NumberofBoomerangs method= new NumberofBoomerangs();

        int[] input = {-2, 1, -1, -2, -2};
        int[][] hits = {{1,0}, {0,0}, {2,0}};
        String[] strs = {"meet", "met"};
        List<String> stringList = new ArrayList<>(Arrays.asList(strs));

        System.out.print(method.numberOfBoomerangs(hits));
//        method.next(1);
//        method.next(10);
//        method.next(3);
//        method.next(5);
    }
}
