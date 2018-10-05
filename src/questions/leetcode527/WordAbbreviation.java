package questions.leetcode527;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        HashMap<String, List<Integer>> presuf_index = new HashMap<>();
        HashMap<Integer, String> index_abbr = new HashMap<>();
        List<String> ans = new ArrayList<>();

        // Group by prefix, suffix.
        for (int i=0; i<dict.size(); i++) {
            String str = dict.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            sb.append(str.charAt(str.length()-1));
            sb.append(str.length());
            if (!presuf_index.containsKey(sb.toString()))
                presuf_index.put(sb.toString(), new ArrayList<>());
            presuf_index.get(sb.toString()).add(i);
        }

        // Build trie for each group.
        for (List<Integer> indexes: presuf_index.values()) {
            Trie root = new Trie();
            for (int index: indexes) {
                String str = dict.get(index);
                Trie curr = root;
                curr.kids++;
                for (char c: str.toCharArray()) {
                    if (curr.children[c-'a'] == null)
                        curr.children[c-'a'] = new Trie();
                    curr = curr.children[c-'a'];
                    curr.kids++;
                }
            }
            for (int index: indexes) {
                String str = dict.get(index);
                Trie curr = root;
                StringBuilder sb = new StringBuilder();
                int len = str.length();
                for (char c: str.toCharArray()) {
                    sb.append(c);
                    curr = curr.children[c-'a'];
                    if (curr.kids == 1) {
                        sb.append(len-sb.length()-1);
                        sb.append(str.charAt(len-1));
                        break;
                    }
                }
                if (sb.length() >= str.length())
                    index_abbr.put(index, str);
                else
                    index_abbr.put(index, sb.toString());
            }
        }

        for (int i=0; i<dict.size(); i++) {
            ans.add(index_abbr.get(i));
        }
        return ans;
    }

    private class Trie {
        int kids;
        Trie[] children;

        Trie() {
            kids = 0;
            children = new Trie[26];
        }
    }
}
