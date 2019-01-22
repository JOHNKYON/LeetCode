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

    List<String> ans;
    public List<String> findWords2(char[][] board, String[] words) {
        ans = new ArrayList<>();
        if (board == null || board.length == 0)
            return ans;

        TreeNode root = new TreeNode();
        for (String word: words) {
            buildTree(root, word);
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                search(new StringBuilder(), board, i, j, root);
            }
        }
        return ans;
    }

    private void search(StringBuilder sb, char[][] board, int i, int j, TreeNode root) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#')
            return;

        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        char temp = board[i][j];
        int index = temp - 'a';
        board[i][j] = '#';
        if (root.kids[index] != null) {
            sb.append(temp);
            root = root.kids[index];
            if (root.flag) {
                ans.add(sb.toString());
                root.flag = false;
            }

            for (int[] move: moves) {
                search(sb, board, i+move[0], j+move[1], root);
            }
            sb.deleteCharAt(sb.length()-1);
        }
        board[i][j] = temp;
    }

    private void buildTree(TreeNode root, String s) {
        TreeNode curr = root;
        for (char c: s.toCharArray()) {
            int index = c - 'a';
            if (curr.kids[index] == null)
                curr.kids[index] = new TreeNode();
            curr = curr.kids[index];
        }
        curr.flag = true;
    }

    private class TreeNode {
        TreeNode[] kids;
        boolean flag;

        public TreeNode() {
            kids = new TreeNode[26];
            flag = false;
        }
    }
}
