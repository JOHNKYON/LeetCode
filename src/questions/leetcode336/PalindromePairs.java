package questions.leetcode336;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<words.length; i++)
            map.put(words[i], i);

        for (int i=0; i<words.length; i++){
            String word = words[i];

            for (int j=0; j<=word.length(); j++){
                String str1 = word.substring(0, j);
                String str2 = word.substring(j);

                if (isPalindrome(str1)){
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rev) && map.get(str2rev) != i){
                        List<Integer> pair = new ArrayList<>();
                        pair.add(map.get(str2rev));
                        pair.add(i);
                        res.add(pair);
                    }
                } if (isPalindrome(str2)){
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rev) && map.get(str1rev) != i && str2.length()!=0){
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(map.get(str1rev));
                        res.add(pair);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String word){
        char[] chars = new char[word.length() * 2 + 2];
        chars[0] = '$';
        chars[1] = '#';
        for (int i=0; i<word.length(); i++){
            chars[(i+1)*2] = word.charAt(i);
            chars[(i+1)*2+1] = '#';
        }

        int mid = word.length() + 1;
        for (int bias=1; bias<=word.length(); bias++){
            if (chars[mid - bias] != chars[mid + bias])
                return false;
        }
        return true;
    }
}
