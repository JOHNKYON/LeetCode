package questions.leetcode715;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class RangeModule {
    TreeSet<Interval> ranges;
    public RangeModule() {
        ranges = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left-1)).iterator();
        while(itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left) break;
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            itr.remove();
        }
        ranges.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Interval iv = ranges.higher(new Interval(0, left));
        return (iv != null && iv.left <= left && right <= iv.right);
    }

    public void removeRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> todo = new ArrayList();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left) break;
            if (iv.left < left)
                todo.add(new Interval(iv.left, left));
            if (right < iv.right)
                todo.add(new Interval(right, iv.right));
            itr.remove();
        }
        for (Interval iv: todo)
            ranges.add(iv);
    }

    private class Interval implements Comparable<Interval>{
        int left;
        int right;
        public Interval(int l, int r) {
            left = l;
            right = r;
        }

        public int compareTo(Interval b) {
            if (right == b.right)
                return left - b.left;
            return right - b.right;
        }
    }
}
