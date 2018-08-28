package questions.leetcode753;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
    Set<String> set;
    StringBuilder res;
    public String crackSafe(int n, int k) {
        set = new HashSet<>();
        res = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n-1; i++){
            sb.append("0");
        }
        String start = sb.toString();

        dfs(start, k);
        res.append(start);
        return res.toString();
    }

    private void dfs(String node, int k){
        for (int i=0; i<k; i++){
            String now = node + i;
            if (!set.contains(now)){
                set.add(now);
                dfs(now.substring(1), k);
                res.append(i);
            }
        }
    }
}
