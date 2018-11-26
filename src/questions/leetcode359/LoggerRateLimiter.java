package questions.leetcode359;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    Map<String, Integer> hashmap;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        hashmap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer last_time = hashmap.get(message);
        if (last_time == null || timestamp - last_time >= 10) {
            last_time = timestamp;
            hashmap.put(message, last_time);
            return true;
        }
        return false;
    }
}
