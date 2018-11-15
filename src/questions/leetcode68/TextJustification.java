package questions.leetcode68;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int curr_len = 0;
        int start = 0;
        int end = 0;
        for (String word: words) {
            if (curr_len == 0 || curr_len + word.length() + 1 <= maxWidth) {
                if (curr_len != 0)
                    curr_len += 1;
                curr_len += word.length();
            } else {
                StringBuilder sb = new StringBuilder();
                int spaces = maxWidth - curr_len;
                if (start == end - 1) {
                    sb.append(words[start]);
                    while(spaces-- != 0)
                        sb.append(' ');
                } else {
                    int per_space = spaces / (end - start - 1);
                    int spare = spaces - per_space* (end - start - 1);
                    for (int i=start; i<end-1; i++) {
                        sb.append(words[i]);
                        for (int j=0; j<=per_space; j++)
                            sb.append(' ');
                        if (spare-- > 0)
                            sb.append(' ');
                    }
                    sb.append(words[end-1]);
                }
                res.add(sb.toString());
                start = end;
                curr_len = word.length();
            }
            end++;
        }
        if (curr_len != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i=start; i<end-1; i++) {
                sb.append(words[i]);
                sb.append(' ');
            }
            sb.append(words[end-1]);
            while (sb.length() < maxWidth)
                sb.append(' ');
            res.add(sb.toString());
        }

        return res;
    }
}