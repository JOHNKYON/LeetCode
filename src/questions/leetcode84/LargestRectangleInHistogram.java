package questions.leetcode84;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] bars) {
        int max = 0;
        int i=0;

        Stack<Integer> stack = new Stack<>();

        while (i< bars.length){
            if (stack.isEmpty() || bars[i] >= bars[stack.peek()]){
                stack.push(i++);
            }
            else{
                int temp = stack.pop();

                int cur = (bars[temp]) * ((stack.isEmpty())? i: i-stack.peek()-1);
                max = (max > cur)? max:cur;
            }
        }
        while(!stack.isEmpty()){
            int temp = stack.pop();

            int cur = (bars[temp]) * ((stack.isEmpty())? i: i-stack.peek()-1);
            max = (max > cur)? max:cur;
        }

        return max;
    }
}
