package questions.leetcode43;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num2.length(); i++) {
            sb.append("0");
            String curr = oneBitMul(num1, num2.charAt(i));
            if (curr.equals("0"))
                continue;
            stringSum(sb, curr);
        }
        return sb.toString();
    }

    private void stringSum(StringBuilder sb, String str) {
        int i = 0;
        int c = 0;
        for (i=0; i<Math.max(sb.length(), str.length()); i++) {
            int sbi = sb.length() - 1 - i;
            int stri = str.length() - 1 - i;
            if (sbi < 0) {
                int num = str.charAt(stri) - '0' + c;
                sb.insert(0, num % 10);
                c = num / 10;
            }
            else if (stri < 0) {
                int num = sb.charAt(sbi) - '0' + c;
                sb.setCharAt(sbi, (char)('0' + num % 10));
                c = num / 10;
            } else {
                int num = sb.charAt(sbi) - '0' + str.charAt(stri) - '0' + c;
                sb.setCharAt(sbi, (char)('0' + num % 10));
                c = num / 10;
            }
        }
        if (c != 0)
            sb.insert(0, c);
    }

    private String oneBitMul(String num1, char num2) {
        if (num2 == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        int c = 0;

        for (int i=num1.length()-1; i>=0; i--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2 - '0';
            int mul = n1 * n2 + c;
            sb.insert(0, mul % 10);
            c = mul / 10;
        }
        if (c != 0)
            sb.insert(0, c);
        return sb.toString();
    }
}
