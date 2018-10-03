package questions.leetcode737;

import java.util.HashMap;

public class SentenceSimilarity2 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;

        HashMap<String, Integer> map = new HashMap();
        int count = 0;
        DSU dsu = new DSU(2 * pairs.length);

        for (String[] pair: pairs) {
            for (String p: pair) if (!map.containsKey(p)) {
                map.put(p, count++);
            }
            dsu.union(map.get(pair[0]), map.get(pair[1]));
        }

        for (int i=0; i<words1.length; i++){
            String w1 = words1[i];
            String w2 = words2[i];

            if (!w1.equals(w2)){
                if (!map.containsKey(w1) || !map.containsKey(w2) ||
                        dsu.find(map.get(w1)) != dsu.find(map.get(w2)))
                    return false;
            }
        }
        return true;
    }

    private class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for (int i = 0; i < n; ++i)
                parent[i] = i;
        }

        int find(int x){
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y){
            parent[find(x)] = find(y);
        }
    }
}
