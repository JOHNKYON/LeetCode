package questions.leetcode402;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while (k-- > 0) {
            int i=0;
            int len = sb.length();
            for (i=0; i<len-1; i++) {
                if (sb.charAt(i+1) < sb.charAt(i)) {
                    sb.deleteCharAt(i);
                    break;
                }
            }
            if (i == len-1 && i>= 0)
                sb.deleteCharAt(i);
        }
        int i=0;
        while (i<sb.length() && sb.charAt(i) == '0')
            i++;
        if (i == sb.length())
            return "0";
        String ans = sb.substring(i, sb.length());
        return ans;
    }
}
