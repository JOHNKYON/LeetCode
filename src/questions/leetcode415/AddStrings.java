package questions.leetcode415;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i=0; i<num1.length() || i < num2.length() || c!=0; i++) {
            int a = 0, b = 0;
            if (i < num1.length()) {
                a = num1.charAt(num1.length() - i - 1) - '0';
            }
            if (i < num2.length()) {
                b = num2.charAt(num2.length() - i - 1) - '0';
            }
            int num = a + b + c;
            c = num / 10;
            sb.insert(0, num % 10);
        }
        return sb.toString();
    }
}
