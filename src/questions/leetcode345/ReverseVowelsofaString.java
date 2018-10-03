package questions.leetcode345;

public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length-1;

        while (left < right){
            while (left < right && !isVowels(str[left]))
                left++;
            while (left < right && !isVowels(str[right]))
                right--;

            if (left >= right)
                break;

            swap(str, left, right);
            left++;
            right--;
        }

        return new String(str);
    }

    private boolean isVowels(char c){
        if (c == 'a' || c == 'A' ||
                c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' ||
                c == 'o' || c == 'O' ||
                c == 'u' || c == 'U')
            return true;
        return false;
    }

    private void swap(char[] str, int left, int right){
        char temp = str[left];
        str[left] = str[right];
        str[right] = temp;
    }
}
