package questions.leetcode380;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandomO1 {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, map.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int loc = map.get(val);
        if (loc != map.size()-1) {
            int last_val = list.get(list.size()-1);
            list.set(loc, last_val);
            map.put(last_val, loc);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
