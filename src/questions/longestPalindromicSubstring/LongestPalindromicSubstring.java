package questions.longestPalindromicSubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOHNKYON on 2018/3/15.
 * This is a solution to LeetCode Questions.
 */
public class LongestPalindromicSubstring {
    public String longestSubstring(String s){
        String s2 = PrepareString(s);
        int index = 0, length = 0;
        for (int i = 0; i < s2.length(); i++){
            int temp = LongestAt(s2, i);
            if (temp > length){
                length = temp;
                index = i;
            }
        }
        String sWithSharp = s2.subSequence(index-length+1, index+length).toString();
        return Recover(sWithSharp);
    }

    private String PrepareString(String s){
        /**
         * This is a function that prepare String s for further search.
         * It does two things:
         * 1: It add a # to every char in s, for example: aba -> a#b#a#.
         * 2: It add a $ in the begin of the string, foe example: a#b#a# - > $a#b#a#$
         * This makes every string with a even length and causes no edge errors.
         */
        char[] s2 = new char[s.length()*2+2];
        s2[0] = '$';
        s2[s.length()*2+1] = '$';
        for (int i = 0; i < s.length(); i ++){
            int i2 = i*2;
            s2[i2+1] = s.charAt(i);
            s2[i2+2] = '#';
        }
        return new String(s2);
    }

    private int LongestAt(String s, int index){
        /**
         * This is a function that calculates the length of the longest palindromic substring of
         * a string "s" with the middle if the substring at position "index".
         * */
        int length = 0;
        while (s.charAt(index-length) == s.charAt(index+length) && '$'!=s.charAt(index-length) && '$'!=s.charAt(index+length)){
            length++;
        }
        return length;
    }

    private String Recover(String s){
//        List<Character> s2 = new ArrayList<Character>();
        char[] chars = new char[(s.length()+1)/2];
        for (int i = 0; i < s.length(); i++){
            if ('#' != s.charAt(i) && '$' != s.charAt(i)){
                chars[i/2] = s.charAt(i);
            }
        }

        return new String(chars);
    }
}
