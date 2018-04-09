package questions.leetcode155;

import java.util.Stack;

/**
 * Created by JOHNKYON on 2018/4/9.
 * This is a solution to LeetCode Questions.
 */
public class MinStack {
    private Stack<Long> stack;
    private long min;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int x){
        if (stack.isEmpty()){
            stack.push(0L);
            min = x;
        } else {
            stack.push(x-min);
            if (x<min) {min = x;}
        }
    }

    public void pop(){
        if (stack.isEmpty()) {return;}
        Long pop = stack.pop();
        if (pop < 0) {min = min - pop;}
    }

    public int top(){
        Long top = stack.peek();
        if (top > 0){
            return (int) (top+min);
        }else {
            return (int)min;
        }
    }

    public int getMin(){
        return (int)min;
    }

}
