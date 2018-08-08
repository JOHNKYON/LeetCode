package questions.leetcode438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (p.length() > s.length()) return res;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i=0;
        for (i=0; i<p.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c) - 1);
            }
        }
        if(isAnagrams(map))
            res.add(0);

        for (int j=0; i<s.length(); i++, j++){
            char left = s.charAt(j);
            char right = s.charAt(i);
            if (map.containsKey(left)){
                map.put(left, map.get(left) +1);
            }
            if (map.containsKey(right)){
                map.put(right, map.get(right) -1);
            }
            if (isAnagrams(map)) res.add(j+1);
        }

        return res;
    }

    private boolean isAnagrams(HashMap<Character, Integer> map){
        for (Integer i : map.values()){
            if (i != 0)
                return false;
        }
        return true;
    }
}
