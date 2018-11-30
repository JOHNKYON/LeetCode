package questions.leetcode187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (int i=0; i<s.length()-9; i++) {
            if (!seen.contains(s.substring(i, i+10)))
                seen.add(s.substring(i, i+10));
            else
                repeated.add(s.substring(i, i+10));
        }
        return new ArrayList<>(repeated);
    }
}
