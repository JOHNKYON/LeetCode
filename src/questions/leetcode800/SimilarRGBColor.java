package questions.leetcode800;

public class SimilarRGBColor {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');

        for (int i=0; i<3; i++)
            sb.append(transfer(color.substring(i*2+1, i*2+3)));

        return sb.toString();
    }

    private String transfer(String color) {
        StringBuilder sb = new StringBuilder();
        int origin = 0;
        char c = color.charAt(0);
        if (c - '0' >= 10)
            origin += 16 * (c - 'a' + 10);
        else
            origin += 16 * (c - '0');
        c = color.charAt(1);
        if (c - '0' >= 10)
            origin += c - 'a' + 10;
        else
            origin += c - '0';
        int res = origin / 17;
        res = (origin - res * 17 < (res + 1) * 17 - origin)? res: res+1;

        if (res >= 10)
            c = (char)('a' + res - 10);
        else
            c = (char)('0' + res);
        sb.append(c);
        sb.append(c);
        return sb.toString();
    }
}
