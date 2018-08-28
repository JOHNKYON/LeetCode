package questions.leetcode745;

public class PrefixAndSuffixSearch {
    TrieNode trie;

    public PrefixAndSuffixSearch(String[] words) {
        trie = new TrieNode();

        for (int weight=0; weight<words.length; weight++){
            String word = "{" + words[weight];

            insertTrie(word, weight);

            for (int i = words[weight].length()-1; i>=0; i--){
                word = words[weight].charAt(i) + word;
                insertTrie(word, weight);
            }
        }
    }

    public int f(String prefix, String suffix) {
        String search = suffix + "{" + prefix;
        TrieNode curr = trie;
        for (char c : search.toCharArray()){
            curr = curr.children[c-'a'];
            if (curr == null)
                return -1;
        }
        return curr.weight;
    }

    private void insertTrie(String word, int weight){
        TrieNode cur = trie;
        for (char c : word.toCharArray()){
            if (cur.children[c-'a'] == null)
                cur.children[c-'a'] = new TrieNode();
            cur = cur.children[c-'a'];
            cur.weight = weight;
        }
    }

    private class TrieNode{
        TrieNode[] children;
        int weight;

        public TrieNode(){
            children = new TrieNode[27];
            weight = 0;
        }
    }
}
