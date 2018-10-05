import questions.leetcode527.WordAbbreviation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WordAbbreviation method= new WordAbbreviation();

        int[] input = {-2, 1, -1, -2, -2};
        int[][] hits = {{1,1,1}, {7,7,7}, {7,7,7}};
        String[] strs = {"meet", "met"};
        List<String> stringList = new ArrayList<>(Arrays.asList(strs));

        System.out.print(method.wordsAbbreviation(stringList));
//        method.next(1);
//        method.next(10);
//        method.next(3);
//        method.next(5);
    }
}
