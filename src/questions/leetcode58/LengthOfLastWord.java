package questions.leetcode58;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if (words.length == 0)
            return 0;
        return words[words.length-1].length();
    }

    public int lengthOfLastWord2(String s) {
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ')
            right--;
        if (right < 0)
            return 0;
        int left = right;
        while (left >= 0 && s.charAt(left) != ' ')
            left--;
        return right - left;
    }
}
