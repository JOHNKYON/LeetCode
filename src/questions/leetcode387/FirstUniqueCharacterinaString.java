package questions.leetcode387;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] index = new int[26];

        for (int i=0; i<s.length(); i++){
            int ptr = s.charAt(i) - 'a';
            if (index[ptr] != 0)
                index[ptr] = -1;
            else
                index[ptr] = i+1;
        }

        int min = Integer.MAX_VALUE;
        for (int i: index){
            if (i > 0)
                min = Math.min(min, i);
        }
        return (min == Integer.MAX_VALUE)? -1: min-1;
    }
}
