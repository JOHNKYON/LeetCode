package questions.leetcode1028;

public class ConverttoBaseNeg2 {
    public String baseNeg2(int N) {
        if (N == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int remainder = N % (-2);
            N /= -2;
            if (remainder < 0) {
                remainder += 2;
                N += 1;
            }
            sb.insert(0, remainder);
        }
        return sb.toString();
    }
}
