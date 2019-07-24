package questions.weekly137;

import java.util.*;

public class Solution {
    public int lastStoneWeightII2(int[] stones) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int stone: stones) {
            map.put(stone, map.getOrDefault(stone, 0) + 1);
        }
        while (map.size() > 1) {
            int largest = map.lastKey();
            map.put(largest, map.get(largest) -1 );
            if (map.get(largest) == 0) {
                map.remove(largest);
            }
            int second = map.lastKey();
            map.put(second, map.get(second) - 1);
            if (map.get(second) == 0) {
                map.remove(second);
            }
            int rest = largest - second;
            map.put(rest, map.getOrDefault(rest, 0) + 1);
        }
        if (map.isEmpty())
            return 0;
        if (map.get(map.firstKey()) % 2 == 0) {
            return 0;
        }
        return map.firstKey();
    }

    int res;
    public int lastStoneWeightII(int[] stones) {
        res = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int stone: stones) {
            list.add(stone);
        }
        backTrack(list);
        return res;
    }

    private void backTrack(List<Integer> list) {
        if (res == 0) {
            return;
        }
        if (list.size() == 0) {
            res = 0;
            return;
        }
        if (list.size() == 1) {
            res = Math.min(res, list.get(0));
            return;
        }
        for (int i=list.size()-1; i>=0; i--) {
            for (int j=i-1; j>=0; j--) {
                int a = list.get(i);
                int b = list.get(j);
                int rest = Math.abs(a - b);
                list.remove(i);
                list.remove(j);
                if (rest != 0) {
                    list.add(rest);
                }
                backTrack(list);
                if (rest != 0) {
                    list.remove(list.size() - 1);
                }
                list.add(j, b);
                list.add(i, a);
            }
        }
    }
}
