package questions.leetcode56;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOHNKYON on 2018/4/4.
 * This is a solution to LeetCode Questions.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals){
        if (intervals.size() == 0){
            return intervals;
        }

        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals){
            if (res.size() == 0){
                res.add(interval);
            } else {
                int startIndex = 0, start = interval.start, endIndex = 0, end = interval.end;
                for (int i = 0; res.get(i).end < interval.end; i++){
                    if (res.get(i).start <interval.start){
                        startIndex = i;
                        start = interval.start;
                    }
                    endIndex = i;
                }
                end = (end < res.get(endIndex).end)? res.get(endIndex).end : end;
                for (int i = startIndex; i <= endIndex; i++){
                    res.remove(i);
                }
                res.add(new Interval(start, end));
            }

        }
        return res;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public Interval createInterval(int s, int e){
        return new Interval(s, e);
    }
}
