package questions.leetcode299;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        if (secret.length() == 0)   return "0A0B";

        int bulls = 0;
        int cows = 0;
        int[] digits1 = new int[10];
        int[] digits2 = new int[10];

        for (int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            digits1[c1-'0']++;
            digits2[c2-'0']++;
            if (c1 == c2)
                bulls++;
        }
        for (int i=0; i<10; i++){
            cows += Math.min(digits1[i], digits2[i]);
        }
        cows -= bulls;
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("BigButtons");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }
}
