package questions.leetcode127;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Integer> list = new LinkedList<>();
        wordList.add(0, beginWord);
        list.offer(0);
        int size = wordList.size();
        int[] used = new int[size];

        while(!list.isEmpty()) {
            int curr = list.poll();
            String curr_str = wordList.get(curr);
            for (int i=1; i<size; i++) {
                String candidate = wordList.get(i);
                if (used[i] == 0 && canTransform(curr_str, candidate)) {
                    if (candidate.equals(endWord)) {
                        return used[curr] + 2;
                    }
                    used[i] = used[curr] + 1;
                    list.offer(i);
                }
            }
        }

        return 0;
    }

    private boolean canTransform(String s, String t) {
        int diff_count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                diff_count++;
        }
        return diff_count == 1;
    }
}
