package questions.leetcode418;

public class SentenceScreenFiltering {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";

        int ptr = 0;
        int len = s.length();

        int r = 0;
        for (int i=0; i<rows; i++) {
            ptr += cols;
            if (s.charAt(ptr % len) == ' ')
                ptr++;
            else{
                while (ptr >0 && s.charAt((ptr-1) % len) != ' ')
                    ptr--;
            }
        }

        return ptr / len;
    }
}
