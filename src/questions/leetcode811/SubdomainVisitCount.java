package questions.leetcode811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(String s: cpdomains){
            String[] slist = s.split(" ");
            int count = Integer.parseInt(slist[0]);

            String[] domain_list = slist[1].split("[.]");
            StringBuilder strbuilder = new StringBuilder();
            for (int i=domain_list.length-1; i>=0; i--){
                strbuilder.insert(0, domain_list[i]);
                String key = strbuilder.toString();
                map.put(key, map.getOrDefault(key, 0) + count);
                strbuilder.insert(0, ".");
            }
        }

        for (String key: map.keySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(key));
            sb.append(" ");
            sb.append(key);
            res.add(sb.toString());
        }
        return res;
    }
}
