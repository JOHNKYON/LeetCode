package questions.leetcode91;

public class DecodeWays {
    public int numDecodings(String s) {
        int minus2 = 1;
        int minus1 = 1;
        int curr = 1;
        if (s == null || s.length() == 0)
            return 0;

        char c = s.charAt(0);
        if (c-'1' < 0 || c-'1' >= 9)
            return 0;

        for (int i=1; i<s.length(); i++) {
            curr = 0;
            char pre_c = s.charAt(i-1);
            char curr_c = s.charAt(i);

            if (curr_c != '0')
                curr = minus1;

            if (curr_c-'0' < 0 || curr_c-'0' > 9)
                return 0;

            if (pre_c == '1' || (pre_c == '2' && curr_c - '0' >= 0 && curr_c - '0' <= 6))
                curr += minus2;

            minus2 = minus1;
            minus1 = curr;
        }
        return curr;
    }
}
