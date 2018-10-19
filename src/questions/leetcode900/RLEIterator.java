package questions.leetcode900;

public class RLEIterator {
    int[] list;
    int ptr;
    int count;

    public RLEIterator(int[] A) {
        list = A;
        ptr = 0;
        count = 0;

        if (A == null || A.length == 0)
            return;
        count = A[ptr];
    }

    public int next(int n) {
        while (ptr < list.length) {
            if (count - n < 0) {
                n -= count;
                ptr += 2;
                if (ptr == list.length)
                    return -1;
                count = list[ptr];
            } else {
                count -= n;
                return list[ptr+1];
            }
        }
        return -1;
    }
}
