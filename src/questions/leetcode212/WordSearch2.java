package questions.leetcode212;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode trie = buildTrie(words);
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                DFS(i, j, board, trie, res);
            }
        }
        return res;
    }

    private void DFS(int i, int j, char[][] board, TrieNode node, List<String> res){
        char ch = board[i][j];
        if (ch == '#' || node.next[ch-'a'] == null) return;
        node = node.next[ch-'a'];
        if (node.word!=null){
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        if (i>0) DFS(i-1, j, board, node, res);
        if (i<board.length-1) DFS(i+1, j, board, node, res);
        if (j>0) DFS(i, j-1, board, node, res);
        if (j<board[0].length-1) DFS(i, j+1, board, node, res);

        board[i][j] = ch;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();



        for (String word : words){
            TrieNode node = root;
            for (char ch : word.toCharArray()){
                int char_index = ch - 'a';
                if (node.next[char_index] == null) {node.next[char_index] = new TrieNode();}
                node = node.next[char_index];
            }

            node.word = word;
        }
        return root;
    }

    private class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
