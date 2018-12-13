package questions.leetcode767;

import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        for (char c: S.toCharArray()) {
            counts[c-'a']++;
        }

        Queue<Pair> heap = new PriorityQueue<>();
        for (int i=0; i<26; i++) {
            if (counts[i] != 0)
                heap.offer(new Pair((char)(i+'a'), counts[i]));
        }

        if (heap.peek().count > (S.length()+1)/2)
            return "";

        StringBuilder sb = new StringBuilder();
        Pair buffer0 = null;
        while (!heap.isEmpty()) {
            Pair curr = heap.poll();
            sb.append(curr.c);
            curr.count--;
            if (buffer0 != null && buffer0.count != 0)
                heap.offer(buffer0);
            buffer0 = curr;
        }
        return sb.toString();
    }

    private class Pair implements Comparable<Pair>{
        char c;
        int count;
        public Pair(char ch, int n) {
            c = ch;
            count = n;
        }

        @Override
        public int compareTo(Pair that) {
            return that.count - count;
        }
    }
}
