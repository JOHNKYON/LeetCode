package questions.leetcode67;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int an = a.length()-1;
        int bn = b.length()-1;
        int c = 0;
        while (an >=0 || bn >=0){
            int ac=0, bc=0;
            if (an >= 0)
                ac = a.charAt(an) - '0';
            if (bn >= 0)
                bc = b.charAt(bn) - '0';

            int n = ac + bc + c;
            if (n > 1) {
                c = 1;
                n -= 2;
            } else
                c = 0;
            sb.insert(0, (char)('0' + n));


            an--;
            bn--;
        }
        if (c == 1)
            sb.insert(0, (char)('0' + c));
        return sb.toString();
    }
}
