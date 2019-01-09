package questions.leetcode609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String str: paths) {
            String[] segs = str.split(" ");
            String path = segs[0];
            for (int i=1; i<segs.length; i++) {
                String file = segs[i];
                int left_idx = file.indexOf('(');
                String key = file.substring(left_idx, file.length()-1);
                if (!map.containsKey(key))
                    map.put(key, new ArrayList<>());
                map.get(key).add(path+"/"+file.substring(0, left_idx));
            }
        }
        for (List<String> set: map.values()) {
            if (set.size() > 1)
                ans.add(set);
        }
        return ans;
    }
}
