package questions.leetcode38;

public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for (int i=1; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            char curr = str.charAt(0);
            int count = 1;
            for (int j=1; j<str.length(); j++) {
                if (str.charAt(j) != curr) {
                    sb.append(count);
                    sb.append(curr);
                    curr = str.charAt(j);
                    count = 1;
                } else
                    count++;
            }
            sb.append(count);
            sb.append(curr);
            str = sb.toString();
        }

        return str;
    }
}
