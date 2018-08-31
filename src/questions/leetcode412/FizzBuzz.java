package questions.leetcode412;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int threes = 3;
        int fives = 5;

        for (Integer i=1; i<=n; i++){
            int th = i - threes;
            int fi = i - fives;

            if (th != 0 && fi != 0)
                res.add(i.toString());
            else if (th == 0 && fi != 0){
                res.add("Fizz");
                threes += 3;
            }
            else if (th != 0 && fi == 0){
                res.add("Buzz");
                fives += 5;
            }
            else {
                res.add("FizzBuzz");
                threes +=3;
                fives += 5;
            }
        }

        return res;
    }
}
