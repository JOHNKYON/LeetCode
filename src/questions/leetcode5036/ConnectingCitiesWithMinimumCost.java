package questions.leetcode5036;

import java.util.*;

public class ConnectingCitiesWithMinimumCost {
    public int minimumCost(int n, int[][] connections) {
        int[] next = new int[n+1];
        Arrays.fill(next, Integer.MAX_VALUE);
        Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int[] connection: connections) {
            int a = connection[0], b = connection[1], cost = connection[2];
            if (!map.containsKey(a)) {
                map.put(a, new HashMap<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new HashMap<>());
            }
            map.get(a).put(b, Math.min(cost, map.get(a).getOrDefault(b, Integer.MAX_VALUE)));
            map.get(b).put(a, Math.min(cost, map.get(b).getOrDefault(a, Integer.MAX_VALUE)));
        }
        if (map.size() < n) {
            return -1;
        }

        long ans = 0;
        int used = 1;
        Map<Integer, Integer> nexts = map.get(1);
        for (Map.Entry<Integer, Integer> entry: nexts.entrySet()) {
            next[entry.getKey()] = entry.getValue();
        }
        next[1] = -1;
        while (used < n) {
            int node = -1;
            int dis = Integer.MAX_VALUE;
            for (int i=1; i<=n; i++) {
                if (next[i] != -1 && next[i] < dis) {
                    node = i;
                    dis = next[i];
                }
            }
            if (node == -1) {
                return -1;
            }

            ans += dis;
            nexts = map.get(node);
            for (Map.Entry<Integer, Integer> entry: nexts.entrySet()) {
                int nextNode = entry.getKey();
                int nextDis = entry.getValue();
                if (nextDis < next[nextNode]) {
                    next[nextNode] = nextDis;
                }
            }
            used++;
            next[node] = -1;
        }
        return Math.toIntExact(ans);
    }
}
