package questions.leetcode686;

public class RepeatedStringMatch {
    private int[] next;

    public int repeatedStringMatch(String A, String B) {
        StringBuilder A2 = new StringBuilder();

        next = buildKMP(B);

        int repeated = 0;
        while (A2.length() < B.length()) {
            A2.append(A);
            repeated++;
        }

        for (int i=0; i<2; i++){
            if (isSubString(A2, B))
                return repeated+i;
            else
                A2.append(A);
        }

        return -1;
    }

    private boolean isSubString(StringBuilder sb, String s){
        if (sb.length() < s.length())   return false;

        int i=0, j=0;
        while (j==s.length() || i + j < sb.length()){
            if (j==s.length())  return true;

            if (sb.charAt(i+j) == s.charAt(j))
                j++;
            else{
                j = (j == 0)? 1: j;
                i += j - next[j-1];
                j = next[j-1];
            }
        }
        return false;
    }

    private int[] buildKMP(String s){
        int[] next = new int[s.length()];

        for (int i=0; i<s.length(); i++){
            int temp = 0;
            for (int j=1; j<=i; j++){
                if (s.substring(0, j).equals(s.substring(i-j+1, i+1))){
                    temp = j;
                }
            }
            next[i] = temp;
        }

        return next;
    }
}
