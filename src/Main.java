import questions.leetcode447.NumberofBoomerangs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        NumberofBoomerangs method= new NumberofBoomerangs();

        int[] input = {186,419,83,408};
        int[][] hits = {{1,0}, {0,0}, {2,0}};
        String[] strs = {"meet", "met"};
        List<String> stringList = new ArrayList<>(Arrays.asList(strs));

        System.out.print(coinChange(input, 6249));
//        method.next(1);
//        method.next(10);
//        method.next(3);
//        method.next(5);
    }

    static int coinChange(int[] coins, int total) {
        if (total == 0)
            return 0;
        Arrays.sort(coins);
        for (int i=coins.length-1; i>=0; i--) {
            if (coins[i] == total)
                return 1;
            if (coins[i] > total)
                continue;
            int temp = coinChange(coins, total-coins[i]);
            if (temp != -1)
                return temp+1;
        }
        return -1;
    }
}
