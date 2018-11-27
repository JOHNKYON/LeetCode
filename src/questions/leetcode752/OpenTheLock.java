package questions.leetcode752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        for (String str: deadends) {
            if (!dead.contains(str))
                dead.add(str);
        }
        Queue<Code> candidates = new LinkedList<>();
        if (dead.contains("0000"))
            return -1;
        candidates.offer(new Code("0000", 0));
        seen.add("0000");

        while (!candidates.isEmpty()) {
            Code curr = candidates.poll();
            if (curr.str.equals(target))
                return curr.count;
            String node = curr.str;
            for (int i = 0; i < 4; ++i) {
                for (int d = -1; d <= 1; d += 2) {
                    int y = ((node.charAt(i) - '0') + d + 10) % 10;
                    String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
                    if (!seen.contains(nei) && !dead.contains(nei)) {
                        seen.add(nei);
                        candidates.offer(new Code(nei, curr.count+1));
                    }
                }
            }
        }
        return -1;
    }

    private void moveWheel(StringBuilder sb, int i) {

    }

    private class Code {
        String str;
        int count;
        public Code(String s, int c) {
            str = s;
            count = c;
        }
    }
}
