package questions.leetcode642;

import java.util.*;

public class AutocompleteSystem {
//    class Node {
//        Node(String st, int t) {
//            sentence = st;
//            times = t;
//        }
//        String sentence;
//        int times;
//    }
//    class Trie {
//        int times;
//        Trie[] branches = new Trie[27];
//    }
//    public int int_(char c) {
//        return c == ' ' ? 26 : c - 'a';
//    }
//    public void insert(Trie t, String s, int times) {
//        for (int i = 0; i < s.length(); i++) {
//            if (t.branches[int_(s.charAt(i))] == null)
//                t.branches[int_(s.charAt(i))] = new Trie();
//            t = t.branches[int_(s.charAt(i))];
//        }
//        t.times += times;
//    }
//    public List < Node > lookup(Trie t, String s) {
//        List < Node > list = new ArrayList < > ();
//        for (int i = 0; i < s.length(); i++) {
//            if (t.branches[int_(s.charAt(i))] == null)
//                return new ArrayList < Node > ();
//            t = t.branches[int_(s.charAt(i))];
//        }
//        traverse(s, t, list);
//        return list;
//    }
//    public void traverse(String s, Trie t, List < Node > list) {
//        if (t.times > 0)
//            list.add(new Node(s, t.times));
//        for (char i = 'a'; i <= 'z'; i++) {
//            if (t.branches[i - 'a'] != null)
//                traverse(s + i, t.branches[i - 'a'], list);
//        }
//        if (t.branches[26] != null)
//            traverse(s + ' ', t.branches[26], list);
//    }
//    Trie root;
//    public AutocompleteSystem(String[] sentences, int[] times) {
//        root = new Trie();
//        for (int i = 0; i < sentences.length; i++) {
//            insert(root, sentences[i], times[i]);
//        }
//    }
//    String cur_sent = "";
//    public List < String > input(char c) {
//        List< String > res = new ArrayList< >();
//        if (c == '#') {
//            insert(root, cur_sent, 1);
//            cur_sent = "";
//        } else {
//            cur_sent += c;
//            List < Node > list = lookup(root, cur_sent);
//            Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
//            for (int i = 0; i < Math.min(3, list.size()); i++)
//                res.add(list.get(i).sentence);
//        }
//        return res;
//    }

//    Trie root;
//    Trie curr;
//    StringBuilder sb;
//    HashMap<String, Sentence> map;
//    // MyComparator comparator;
//
//    public AutocompleteSystem(String[] sentences, int[] times) {
//        // list = new ArrayList<>();
//        root = new Trie();
//        map = new HashMap<>();
//        for (int i=0; i<sentences.length; i++) {
//            Sentence sentence = new Sentence(sentences[i], times[i]);
//            // list.add(sentence);
//            buildTrie(sentence);
//            map.put(sentences[i], sentence);
//        }
//        sortTrie(root);
//        curr = root;
//        sb = new StringBuilder();
//        // comparator = new MyComparator();
//    }
//
//    public List<String> input(char c) {
////        System.out.print(c);
//        List<String> ans = new ArrayList<>();
//        if (c == '#') {
//            insert(root, new Sentence(sb.toString(), 1));
//            reset();
//            return ans;
//        }
//        sb.append(c);
//        if (curr == null)
//            return ans;
//        int idx = c - 'a';
//        if (c == ' ')
//            idx = 26;
//        curr = curr.kids[idx];
//        if (c == '#' || curr == null)
//            return ans;
//        // if (c == 'a')
//        //     System.out.println(curr.candidates.size());
//        for (int i=0; i<3 && i <curr.candidates.size(); i++) {
//            ans.add(curr.candidates.get(i).str);
//        }
//        return ans;
//    }
//
//    private void insert(Trie root, Sentence s) {
//        boolean contains = map.containsKey(s.str);
//        if (contains) {
//            map.get(s.str).count++;
//        } else
//            map.put(s.str, s);
//        Trie curr = root;
//        String str = s.str;
//        for (int i=0; i<=str.length(); i++) {
//            // System.out.print(c + " " + curr.candidates.size() + " ");
//
//            if (!contains) {
//                curr.candidates.add(s);
//            }
//            Collections.sort(curr.candidates, new MyComparator());
//            // System.out.println(curr.candidates.size());
//            if (i == str.length())
//                return;
//            char c = str.charAt(i);
//            int idx = c == ' '? 26: c - 'a';
//            if (curr.kids[idx] == null)
//                curr.kids[idx] = new Trie();
//            curr = curr.kids[idx];
//        }
//    }
//
//    private void reset() {
//        curr = root;
//        sb = new StringBuilder();
//    }
//
//    private void buildTrie(Sentence s) {
//        Trie node = root;
//        String str = s.str;
//        for (int i=0; i<=str.length(); i++) {
//            node.candidates.add(s);
//            if (i == str.length())
//                return;
//            char c = str.charAt(i);
//            int idx = c - 'a';
//            if (c == ' ')
//                idx = 26;
//            if (node.kids[idx] == null) {
//                node.kids[idx] = new Trie();
//            }
//            node = node.kids[idx];
//        }
//    }
//
//    private void sortTrie(Trie node) {
//        if (node == null)
//            return;
//        Collections.sort(node.candidates, new MyComparator());
//        for (int i=0; i<27; i++) {
//            sortTrie(node.kids[i]);
//        }
//    }
//
//    private class Trie{
//        Trie[] kids;
//        List<Sentence> candidates;
//        public Trie() {
//            kids = new Trie[27];
//            candidates = new ArrayList<>();
//        }
//    }
//
//    private class Sentence{
//        String str;
//        int count;
//        public Sentence(String _str, int _count) {
//            str = _str;
//            count = _count;
//        }
//    }
//
//    class MyComparator implements Comparator<Sentence> {
//        @Override
//        public int compare(Sentence a, Sentence b) {
//            if (a.count == b.count) {
//                return a.str.compareTo(b.str);
//            }
//            return b.count - a.count;
//        }
//    }

    HashMap<String, Candidate> map;
    Trie root;
    Trie curr;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        curr = root;
        sb = new StringBuilder();
        map = new HashMap<>();
        for (int i=0; i<sentences.length; i++) {
            map.put(sentences[i], new Candidate(sentences[i], times[i]));
            insert(sentences[i]);
        }
    }

    public List<String> input(char c) {
        List<String> ans = new ArrayList<>();
        if (c == '#') {
            String query = sb.toString();
            if (map.containsKey(query)) {
                map.get(query).count++;
            } else {
                map.put(query, new Candidate(query, 1));
                insert(query);
            }

            sb = new StringBuilder();
            curr = root;
            return ans;
        }

        sb.append(c);
        int idx = c - 'a';
        if (c == ' ') {
            idx = 26;
        }
        if (curr.kids[idx] == null) {
            curr.kids[idx] = new Trie();
        }
        curr = curr.kids[idx];
        Collections.sort(curr.candidates, new Comparator<String>() {
            @Override
            public int compare(String _a, String _b) {
                Candidate a = map.get(_a);
                Candidate b = map.get(_b);
                if (a.count == b.count) {
                    return a.word.compareTo(b.word);
                }
                return b.count - a.count;
            }
        });

        for (int i=0; i<3 && i < curr.candidates.size(); i++) {
            ans.add(curr.candidates.get(i));
        }
        return ans;
    }

    private void insert(String s) {
        Trie curr = root;
        for (char c: s.toCharArray()) {
            int idx = c - 'a';
            if (c == ' ') {
                idx = 26;
            }
            if (curr.kids[idx] == null) {
                curr.kids[idx] = new Trie();
            }
            curr = curr.kids[idx];
            curr.candidates.add(s);
        }
    }

    private class Trie {
        Trie[] kids;
        List<String> candidates;

        public Trie() {
            kids = new Trie[27];
            candidates = new ArrayList<>();
        }
    }

    private class Candidate{
        String word;
        int count;

        public Candidate(String _word, int _count) {
            word = _word;
            count = _count;
        }
    }
}