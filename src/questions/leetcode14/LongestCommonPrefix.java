package questions.leetcode14;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        StringBuilder sb = new StringBuilder(strs[0]);
        for (String str: strs) {
            int i=0;
            for (; i<sb.length() && i<str.length(); i++) {
                if (sb.charAt(i) != str.charAt(i)) {
                    break;
                }
            }
            sb.setLength(i);
        }
        return sb.toString();
    }
}
