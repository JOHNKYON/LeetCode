package questions.leetcode815;

import java.util.*;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T)
            return 0;

        HashMap<Integer, List<Integer>> stop_bus = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> waiting_list = new LinkedList<>();

        for (int i=0; i<routes.length; i++) {
            for (int j=0; j<routes[i].length; j++) {
                List<Integer> buses = stop_bus.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                stop_bus.put(routes[i][j], buses);
            }
        }

        int ans = 0;
        waiting_list.offer(S);
        while (!waiting_list.isEmpty()) {
            int len = waiting_list.size();
            ans++;
            for (int i=0; i<len; i++) {

                int curr = waiting_list.poll();
                List<Integer> buses = stop_bus.get(curr);
                for (int bus: buses) {
                    if (visited.contains(bus))  continue;
                    visited.add(bus);

                    for (int j=0; j<routes[bus].length; j++) {
                        if (routes[bus][j] == T)    return ans;
                        waiting_list.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
