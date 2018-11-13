package questions.leetcode636;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] times = new int[n];
        int last_time = 0;
        boolean last_start = true;

        Stack<Integer> ids = new Stack<>();
        for (String log: logs) {
            String[] subs = log.split(":");
            int id = Integer.parseInt(subs[0]);
            int time = Integer.parseInt(subs[2]);

            if (subs[1].equals("start")) {
                if (!ids.isEmpty()) {
                    int top = ids.peek();
                    times[top] += last_start? time - last_time: time - last_time-1;
                }
                ids.push(id);
                last_time = time;
                last_start = true;
            } else {
                ids.pop();
                times[id] += last_start? time - last_time + 1: time - last_time;
                last_time = time;
                last_start = false;
            }
        }

        return times;
    }
}
