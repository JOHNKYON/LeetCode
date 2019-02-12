package questions.leetcode937;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                int space_idx1 = s1.indexOf(" ");
                int space_idx2 = s2.indexOf(" ");
                String identifier1 = s1.substring(0, space_idx1);
                String identifier2 = s2.substring(0, space_idx2);
                String log1 = s1.substring(space_idx1+1, s1.length());
                String log2 = s2.substring(space_idx2+1, s2.length());
                int digit1 = isDigit(log1);
                int digit2 = isDigit(log2);
                if (digit1 != digit2) {
                    return digit1 - digit2;
                }

                else if (digit1 == 1) {
                    // Both digit
                    return 0;
                } else {
                    // Both alphabet
                    int log_compare = log1.compareTo(log2);
                    if (log_compare == 0) {
                        // Tie
                        return identifier1.compareTo(identifier2);
                    }
                    return log_compare;
                }
            }
        });
        return logs;
    }

    private int isDigit(String s) {
        char c = s.charAt(0);
        if (c - '0' >= 0 && c - '0' <= 9)
            return 1;
        else
            return 0;
    }
}
