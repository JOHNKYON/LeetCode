package questions.leetcode57;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    private class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval a, Interval b){
            return a.start < b.start? -1 : a.start == b.start? 0 : 1;
        }
    }
//    private class IntervalComparator implements Comparator<Interval> {
//        @Override
//        public int compare(Interval a, Interval b) {
//            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1 ;
//        }
//    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
        int start = newInterval.start, end = newInterval.end;

        Collections.sort(intervals, new IntervalComparator());

        int i = 0;
        while (i < intervals.size() && newInterval.start > intervals.get(i).end ) {
            i++;
        }
        if (i == intervals.size() || intervals.get(i).start > end){
            intervals.add(newInterval);
            Collections.sort(intervals, new IntervalComparator());
            return intervals;
        }
        start = (start < intervals.get(i).start)? start : intervals.get(i).start;
        while (i < intervals.size() && intervals.get(i).start <= end){
            end = (end > intervals.get(i).end)? end : intervals.get(i).end;
            intervals.remove(i);
        }
        intervals.add(new Interval(start, end));
        Collections.sort(intervals, new IntervalComparator());
        return intervals;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        public void print(){
            System.out.print(start);
            System.out.print(' ');
            System.out.print(end);
            System.out.print('\n');
        }
    }

    public Interval createInterval(int s, int e){
        return new Interval(s, e);
    }
}
