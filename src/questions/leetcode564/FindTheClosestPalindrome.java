package questions.leetcode564;

public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        if (n.equals("1"))
            return "0";

        String a = mirroring(n);
        long diff1 = Long.MAX_VALUE;
        diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));

        if (diff1 == 0)
            diff1 = Long.MAX_VALUE;

        StringBuilder sb = new StringBuilder(n);
        int i = (sb.length()-1) / 2;
        while (i >= 0 && sb.charAt(i) == '0') {
            // If the mid digit is 0, subtract to 9 for all the
            // continous 0s.
            sb.replace(i, i+1, "9");
            i--;
        }
        if (i==0 && sb.charAt(i) == '1') {
            // If the subtract goes to the beginning
            // 1, remove it.
            sb.delete(0, 1);
            int mid = (sb.length()-1) / 2;
            sb.replace(mid, mid+1, "9");
        } else {
            sb.replace (i, i+1, "" + (char)(sb.charAt(i)-1));
        }

        String b = mirroring(sb.toString());
        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));

        sb = new StringBuilder(n);
        i = (sb.length()-1) / 2;
        while (i >= 0 && sb.charAt(i) == '9') {
            sb.replace(i, i+1, "0");
            i--;
        } if (i < 0) {
            sb.insert(0, "1");
        } else
            sb.replace(i, i+1, "" + (char)(sb.charAt(i)+1));

        String c = mirroring(sb.toString());
        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));

        if (diff2 <= diff1 && diff2 <= diff3)
            return b;
        if (diff1 <= diff3 && diff1 <= diff2)
            return a;
        else
            return c;
    }

    private String mirroring(String s) {
        String half = s.substring(0, s.length()/2);
        return half + (((s.length() & 1) == 1)? s.charAt(s.length()/2): "") + new StringBuilder(half).reverse().toString();
    }
}
