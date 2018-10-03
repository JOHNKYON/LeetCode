package questions.leetcode849;

public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int ptr = 0;

        if (seats[0] == 0) {
            while (seats[++ptr] == 0);
            res = ptr;
        }
        int left = ptr;
        ptr++;
        while (ptr < seats.length) {
            if (seats[ptr] == 1) {
                res = Math.max(res, (ptr-left)/2);
                left = ptr;
            }
            ptr++;
        }

        if (seats[seats.length-1] == 0)
            res = Math.max(res, seats.length-left-1);
        return res;
    }
}
