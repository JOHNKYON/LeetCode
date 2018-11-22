package questions.leetcode157;

public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        if (n == 0)
            return 0;
        int call = (n-1)/4 + 1;
        int count = 0;
        int curr = 0;
        while (count < call) {
            char[] buffer = new char[4];
            int buf_len = read4(buffer);
            if (buf_len == 0)
                break;
            else
                for (int i=0; i<buf_len; i++) {
                    buf[curr] = buffer[i];
                    curr++;
                    if (curr == n)
                        break;
                }
            count++;
        }
        return curr;
    }

    private int read4(char[] buf){
        return 0;
    }
}
