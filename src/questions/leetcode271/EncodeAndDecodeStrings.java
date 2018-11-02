package questions.leetcode271;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            while (s.charAt(right) != '#')
                right++;

            int length = Integer.parseInt(s.substring(left, right));
            right++;
            left = right;
            right += length;
            res.add(s.substring(left, right));
            left = right;
        }

        return res;
    }
}
