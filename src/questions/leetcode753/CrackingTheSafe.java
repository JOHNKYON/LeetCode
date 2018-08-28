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

    // TODO: Understand the algorithm.
    public String crackSafe2(int n, int k) {
        int M = (int) Math.pow(k, n-1);
        int[] P = new int[M * k];
        for (int i = 0; i < k; ++i)
            for (int q = 0; q < M; ++q)
                P[i*M + q] = q*k + i;

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M*k; ++i) {
            int j = i;
            while (P[j] >= 0) {
                ans.append(String.valueOf(j / M));
                int v = P[j];
                P[j] = -1;
                j = v;
            }
        }

        for (int i = 0; i < n-1; ++i)
            ans.append("0");
        return new String(ans);
    }
}
