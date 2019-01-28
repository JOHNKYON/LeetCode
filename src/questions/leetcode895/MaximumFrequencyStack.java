package questions.leetcode895;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    Map<Integer, Integer> num_freq;
    Map<Integer, Stack<Integer>> freq_stack;
    int max_freq;

    public MaximumFrequencyStack() {
        num_freq = new HashMap<>();
        freq_stack = new HashMap<>();
        max_freq = 0;
    }

    public void push(int x) {
        int freq = num_freq.getOrDefault(x, 0) + 1;
        num_freq.put(x, freq);
        max_freq = Math.max(max_freq, freq);

        freq_stack.computeIfAbsent(freq, s->new Stack<>()).push(x);
    }

    public int pop() {
        if (max_freq == 0)
            return -1;
        Stack<Integer> stack = freq_stack.get(max_freq);
        int x = stack.pop();
        num_freq.put(x, max_freq - 1);
        if (stack.size() == 0)
            max_freq--;
        return x;
    }
}
