package questions.leetcode739;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<temperatures.length; i++){
            while (!stack.isEmpty() &&
                    temperatures[stack.peek()] < temperatures[i]){
                int day = stack.pop();
                res[day] = i-day;
            }
            stack.push(i);
        }

        return res;
    }
}
