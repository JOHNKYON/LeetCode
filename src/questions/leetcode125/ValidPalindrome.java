package questions.leetcode125;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            while(left < s.length() && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while(right >= 0 && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (left >= right)
                return true;
            char c1 = Character.toLowerCase(s.charAt(left));
            char c2 = Character.toLowerCase(s.charAt(right));
            if (c1 != c2)
                return false;
            left++;
            right--;
        }
        return true;
    }
}
