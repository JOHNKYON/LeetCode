package questions.leetcode759;

import questions.dataStructure.Interval;

import java.util.*;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ans = new ArrayList<>();
        List<int[]> events = new ArrayList<>();

        for (List<Interval> employee: schedule) {
            for (Interval itv: employee) {
                events.add(new int[]{itv.start, 1});
                events.add(new int[]{itv.end, -1});
            }
        }

        Collections.sort(events, (a, b) -> a[0]!=b[0]? a[0]-b[0]: a[1]-b[1]);
        int prev = -1, curr = 0;
        for (int[] event: events) {
            if (curr == 0 && prev >= 0 && prev != event[0]) {
                ans.add(new Interval(prev, event[0]));
            }
            curr += event[1];
            prev = event[0];
        }

        return ans;
    }
}
