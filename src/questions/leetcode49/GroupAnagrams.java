package questions.leetcode49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashmap = new HashMap<>();

        for (String str : strs){
            String key = keyConstruct(str);
            if (hashmap.containsKey(key)){
                hashmap.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashmap.put(key, list);
            }
        }
        return new ArrayList<>(hashmap.values());
    }

    private String keyConstruct(String str){
        int[] counts = new int[26];

        String key = "";

        for (char c : str.toCharArray()){
            counts[c-'a'] += 1;
        }

        for(int count : counts) key = key + Integer.toString(count) + "#";
        return key;
    }
}
