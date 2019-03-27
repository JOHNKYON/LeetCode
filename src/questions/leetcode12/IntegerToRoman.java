package questions.leetcode12;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        List<Node> dict = new ArrayList<>();
        buildDict(dict);
        for (Node curr: dict) {
            int count = num / curr.val;
            num -= count * curr.val;
            while (count-- > 0) {
                sb.append(curr.symbol);
            }
        }
        return sb.toString();
    }

    private void buildDict(List<Node> dict) {
        dict.add(new Node(1000, "M"));
        dict.add(new Node(900, "CM"));
        dict.add(new Node(500, "D"));
        dict.add(new Node(400, "CD"));
        dict.add(new Node(100, "C"));
        dict.add(new Node(90, "XC"));
        dict.add(new Node(50, "L"));
        dict.add(new Node(40, "XL"));
        dict.add(new Node(10, "X"));
        dict.add(new Node(9, "IX"));
        dict.add(new Node(5, "V"));
        dict.add(new Node(4, "IV"));
        dict.add(new Node(1, "I"));
    }

    private class Node{
        int val;
        String symbol;
        public Node (int _val, String _symbol) {
            val = _val;
            symbol = _symbol;
        }
    }
}
