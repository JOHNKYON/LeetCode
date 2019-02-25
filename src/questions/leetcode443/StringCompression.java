package questions.leetcode443;

public class StringCompression {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0)
            return 0;
        int ptr = 0;
        int count = 0;
        char curr = chars[ptr];
        for (int i=0; i<chars.length; i++) {
            if (curr == chars[i]) {
                count++;
            } else {
                if (count == 1) {
                    chars[ptr] = curr;
                    ptr++;
                } else {
                    chars[ptr] = curr;
                    ptr++;
                    String s = Integer.toString(count);
                    for (int j=0; j<s.length(); j++) {
                        chars[ptr] = s.charAt(j);
                        ptr++;
                    }
                }
                curr = chars[i];
                count = 1;
            }
        }
        if (count == 1) {
            chars[ptr] = curr;
            ptr++;
        } else {
            chars[ptr] = curr;
            ptr++;
            String s = Integer.toString(count);
            for (int j=0; j<s.length(); j++) {
                chars[ptr] = s.charAt(j);
                ptr++;
            }
        }
        return ptr;
    }
}
