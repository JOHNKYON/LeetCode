package questions.leetcode246;

public class StrobagrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        char[] str = num.toCharArray();
        if (num.length() == 0)
            return true;
        int left = 0;
        int right = str.length-1;

        while (left < right) {
            if ((str[left] == '0' && str[right] == '0') ||
                    (str[left] == '1' && str[right] == '1') ||
                    (str[left] == '8' && str[right] == '8') ||
                    (str[left] == '6' && str[right] == '9') ||
                    (str[left] == '9' && str[right] == '6')){
                left++;
                right--;
            } else
                return false;
        }
        if (left == right)
            if (str[left] == '0' || str[left] == '1' || str[left] == '8')
                return true;
            else
                return false;
        return true;
    }
}
