package questions.leetcode320;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = track(word);
        return ans;
    }

    private List<String> track(String word) {
        List<String> res = new ArrayList<>();
        res.add(word);
        for (int j = 0; j<word.length(); j++) {
            String prefix = word.substring(0, j);
            for (int i = j; i < word.length(); i++) {
                String trans;
                int count = i - j + 1;
                if (count > 0)
                    trans = Integer.toString(count);
                else
                    trans = "";
                if (i < word.length() - 1)
                    trans = trans.concat(word.substring(i + 1, i + 2));
                trans = prefix.concat(trans);
                List<String> suffix;
                if (i + 2 >= word.length()) {
                    suffix = new ArrayList<>();
                    suffix.add("");
                } else
                    suffix = track(word.substring(i + 2, word.length()));
                for (String str : suffix) {
                    String new_str = trans.concat(str);
                    res.add(new_str);
                }
            }
        }
        return res;
    }
}
