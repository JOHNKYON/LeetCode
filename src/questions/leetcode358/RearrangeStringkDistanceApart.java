package questions.leetcode358;

import java.util.Arrays;
import java.util.Comparator;

public class RearrangeStringkDistanceApart {
    public String rearrangeString(String s, int k) {
        Node[] chs = new Node[26];
        for (int i=0; i<26; i++){
            chs[i] = new Node((char)('a' + i), 0);
        }
        for (char c: s.toCharArray()) {
            chs[c-'a'].count++;
        }

        Arrays.sort(chs, (a, b)-> b.count - a.count);

        if ((chs[0].count-1) * k + 1 > s.length())
            return "";

        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<k; i++) {
            int times = 0;
            int curr = 0;
            while (times * k + i < s.length()) {
                if (chs[curr].count > 0) {
                    sb.setCharAt(times * k + i, chs[curr].c);
                    chs[curr].count--;
                    times++;
                } else {
                    curr++;
                }
            }
        }
        return sb.toString();
    }

    private class Node{
        char c;
        int count;
        public Node(char nc, int n) {
            c = nc;
            count = n;
        }
    }
}
