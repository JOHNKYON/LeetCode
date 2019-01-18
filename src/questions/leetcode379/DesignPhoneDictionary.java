package questions.leetcode379;

import java.util.HashSet;

public class DesignPhoneDictionary {
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    HashSet<Integer> valid;
    public DesignPhoneDictionary(int maxNumbers) {
        valid = new HashSet<>();
        for (int i=0; i<maxNumbers; i++) {
            valid.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!valid.isEmpty()) {
            int ans = valid.iterator().next();
            valid.remove(ans);
            return ans;
        } else
            return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return valid.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (!valid.contains(number))
            valid.add(number);
    }
}
