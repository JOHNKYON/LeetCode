package questions.leetcode647;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        // Manacher's Algorithm
        int count = 0;

        char[] string = new char[s.length()*2+3];
        string[0] = '$';
        string[1] = '#';
        string[string.length-1] = '@';
        for (int i=0; i<s.length(); i++){
            string[(i+1) * 2] = s.charAt(i);
            string[(i+1) * 2 + 1] = '#';
        }

        int[] count_array = new int[string.length];
        int center = 0, right = 0;
        for (int i=1; i<string.length-1; i++){
            count_array[i] = (i < right)? Math.min(right-i, count_array[2*center-i]) : 1;

            while(string[i+count_array[i]] == string[i-count_array[i]]) count_array[i]++;

            if (i+count_array[i] > right){
                center = i;
                right = i + count_array[i];
            }
        }

        for (int i : count_array)   count += i/2;
        return count;
    }
}
