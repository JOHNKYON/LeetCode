package questions.leetcode735;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        boolean f1, f2;
        for (int i : asteroids){
            if (stack.isEmpty()){
                stack.add(i);
                f1 = i > 0;
            }

            else {
                if (i>0)    stack.add(i);
                else {
                    if (stack.peek() < 0)    stack.add(i);
                    else {
                        while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -i)
                            stack.pop();
                        if (!stack.isEmpty() && stack.peek() == -i) stack.pop();
                        else if (stack.isEmpty() || stack.peek() < 0)    stack.add(i);
                    }
                }
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i=size-1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
