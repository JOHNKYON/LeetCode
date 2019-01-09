package questions.leetcode393;

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        for (int i=0; i<data.length; i++) {

            if ((data[i] & 128) == 0)
                continue;

            int count =0;
            int prefix = data[i];
            while (count < 4 && (prefix & 128) != 0) {
                count++;
                prefix <<= 1;
            }
            if (count == 1 || (prefix & 128) != 0 || data.length - i < count)
                return false;

            i++;
            while (count-- > 1) {
                if ((data[i++] & 192) != 128)
                    return false;
            }
            i--;
        }

        return true;
    }
}
