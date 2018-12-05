package questions.leetcode433;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> list = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        int step = 0;
        int count = 0;
        list.offer(start);
        count++;

        while (!list.isEmpty()) {
            String curr = list.poll();
            count--;

            for (String s: bank) {
                if (!set.contains(s) && validTransform(curr, s)) {
                    if (s.equals(end))
                        return step+1;
                    list.offer(s);
                    set.add(s);
                }
            }

            if (count == 0) {
                step++;
                count = list.size();
            }
        }
        return -1;
    }

    private boolean validTransform(String s1, String s2) {
        int count = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count == 1;
    }
}
