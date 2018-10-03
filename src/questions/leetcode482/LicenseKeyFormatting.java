package questions.leetcode482;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        char[] str = S.replaceAll("-", "").toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();

        int mod = str.length % K;

        int i=0;
        while (i < mod){
            sb.append(str[i]);
            i++;
        }

        int count = 0;
        for (; i<str.length; i++) {
            if (count == 0 && i != 0)
                sb.append('-');

            sb.append(str[i]);
            count++;

            if (count == K)
                count = 0;
        }

        return sb.toString();
    }
}
