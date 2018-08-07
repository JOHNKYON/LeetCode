package questions.leetcode347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length];
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()){
            int freq = map.get(key);
            if (bucket[freq-1] == null){
                bucket[freq-1] = new ArrayList<>();
            }
            bucket[freq-1].add(key);
        }

        for (int i = nums.length-1; i>=0 && res.size()<k; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
