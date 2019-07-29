package questions.leetcode756;

import java.util.List;

public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom.length() == 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        return thisLevel(bottom, 0, allowed, sb);
    }

    private boolean thisLevel(String bottom, int ptr, List<String> allowed, StringBuilder sb) {
        if (ptr == bottom.length() - 1) {
            return pyramidTransition(sb.toString(), allowed);
        }
        for (String str: allowed) {
            if (str.substring(0, 2).equals(bottom.substring(ptr, ptr+2))){
                sb.append(str.charAt(2));
                if (thisLevel(bottom, ptr+1, allowed, sb)) {
                    return true;
                }
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
}
