package questions.leetcode760;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        int length = A.length;
        int[] res = new int[length];

        for (int i=0; i<length; i++) {
            List<Integer> list;
            if (!hashmap.containsKey(B[i])){
                list = new ArrayList<>();
                hashmap.put(B[i], list);
            } else
                list = hashmap.get(B[i]);
            list.add(i);
        }

        for (int i=0; i<length; i++) {
            List<Integer> list = hashmap.get(A[i]);
            res[i] = list.get(0);
            list.remove(0);
        }

        return res;
    }
}
