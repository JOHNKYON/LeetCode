import questions.twoSum.TwoSum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{1, 2, 3, 4, 5}, 8)));
    }

}
