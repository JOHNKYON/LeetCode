package questions.leetcode911;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineElection {
    private List<Vote> votes;

    public OnlineElection(int[] persons, int[] times) {
        votes = new ArrayList<>();
        Map<Integer, Integer> hashmap = new HashMap<>();
        int leader = -1;
        int m = 0;

        for (int i=0; i<persons.length; i++) {
            int p = persons[i];
            int t = times[i];
            int c = hashmap.getOrDefault(p, 0) + 1;
            hashmap.put(p, c);

            if (c >= m) {
                if (p != leader) {
                    leader = p;
                    votes.add(new Vote(t, leader));
                }
                m = Math.max(m, c);
            }
        }
        return;
    }

    public int q(int time) {
        int left = 1, right = votes.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (votes.get(mid).time <= time) {
                left = mid + 1;
            } else
                right = mid;
        }
        return votes.get(left-1).person;
    }

    private class Vote {
        int time;
        int person;
        public Vote(int t, int p) {
            time = t;
            person = p;
        }
    }
}
