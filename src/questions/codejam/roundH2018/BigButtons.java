package questions.codejam.roundH2018;

import java.io.*;

public class BigButtons {
    private Trie trie;
    int ans;

    public void solve() throws IOException{
        FileInputStream input = new FileInputStream("/Users/johnkyon/Projects/LeetCode/src/questions/codejam/roundH2018/A-small-attempt0.in");
        File fout = new File("/Users/johnkyon/Projects/LeetCode/src/questions/codejam/roundH2018/A.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

        int cases = Integer.parseInt(bufferedReader.readLine());
        for (int i=1; i <= cases; i++) {
            trie = new Trie(0, false);
            System.out.print(i);
            String[] s = bufferedReader.readLine().split(" ");
            int t = Integer.parseInt(s[0]);
            int p = Integer.parseInt(s[1]);
            for (int j=0; j<p; j++) {
                String prefix = bufferedReader.readLine();
                buildTrie(prefix);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Case #");
            sb.append(i);
            sb.append(": ");
            sb.append(winningSequence(t));
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.close();
        bufferedReader.close();
    }

    private void buildTrie(String s) {
        Trie curr = trie;
        for (int i=0; i<s.length(); i++) {
            if (curr.sharp)
                return;
            int index = 0;
            if (s.charAt(i) == 'R')
                index = 0;
            else
                index = 1;
            if (curr.kids[index] == null)
                curr.kids[index] = new Trie(curr.depth+1, false);
            curr = curr.kids[index];
        }
        curr.sharp = true;
    }

    private int winningSequence(int t) {
        ans = 1;
        for (int i=0; i<t; i++) {
            ans <<= 1;
        }

        cut(t, trie);
        return ans;
    }

    private void cut(int t, Trie node) {
        if (node == null)
            return;
        if (node.sharp) {
            int len = t - node.depth;
            int count = 1;
            for (int i=0; i<len; i++) {
                count <<= 1;
            }
            ans -= count;
            return;
        }
        cut(t, node.kids[0]);
        cut(t, node.kids[1]);
    }

    private class Trie {
        int depth;
        Trie[] kids;
        boolean sharp;

        public Trie(int d, boolean s) {
            depth = d;
            sharp = s;
            kids = new Trie[2];
        }
    }
}
