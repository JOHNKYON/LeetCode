package questions.leetcode638;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (price == null || price.size() == 0)
            return 0;
        HashMap<String, Integer> hashmap = new HashMap<>();

        return minCost(price, special, needs, hashmap);
    }

    private int minCost(List<Integer> price, List<List<Integer>> special, List<Integer> needs, HashMap<String, Integer> hashmap) {
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        boolean minus = false;
        for (Integer need: needs) {
            sb.append(need);
            sb.append('#');
            zero = zero && (need == 0);
            minus = minus || (need < 0);
        }
        if (minus)
            return 10000;
        if (zero)
            return 0;
        if (hashmap.containsKey(sb.toString()))
            return hashmap.get(sb.toString());

        int res = dot(price, needs);
        for (List<Integer> sale: special) {
            List<Integer> clone = new ArrayList<>(needs);
            for (int i=0; i<clone.size(); i++) {
                clone.set(i, clone.get(i) - sale.get(i));
            }
            res = Math.min(res, sale.get(sale.size()-1) + minCost(price, special, clone, hashmap));
        }
        return res;
    }

    private int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i=0; i<a.size(); i++)
            sum += a.get(i) * b.get(i);
        return sum;
    }
}
