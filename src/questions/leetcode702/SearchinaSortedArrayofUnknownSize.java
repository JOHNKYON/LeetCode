package questions.leetcode702;

import questions.dataStructure.ArrayReader;

public class SearchinaSortedArrayofUnknownSize {
    public int search(ArrayReader reader, int target) {
        int hi = 10000;
        return binarySearch(reader, target, 0, hi);
    }

    private int binarySearch(ArrayReader reader, int target, int lo, int hi) {
        if (lo > hi || (reader.get(lo) < target && reader.get(lo+1) == Integer.MAX_VALUE))
            return -1;

        int hi_num = reader.get(hi);
        int lo_num = reader.get(lo);

        int mid = lo + (hi - lo) / 2;
        int mid_val = reader.get(mid);

        if (hi_num != Integer.MAX_VALUE && hi_num >= target && lo_num <= target) {
            return closedSearch(reader, target, lo, hi);
        }

        if (lo_num == Integer.MAX_VALUE || lo_num > target) {
            return binarySearch(reader, target, lo/2, lo-1);
        }

        if (hi_num < target) {
            return binarySearch(reader, target, hi+1, hi*2);
        }

        //if (hi_num == Integer.MAX_VALUE) {
        return binarySearch(reader, target, lo, mid-1);
        //}
    }

    private int closedSearch(ArrayReader reader, int target, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        int mid_num = reader.get(mid);
        if (mid_num == target)
            return mid;
        if (mid_num > target) {
            return closedSearch(reader, target, lo, mid-1);
        } else
            return closedSearch(reader, target, mid+1, hi);
    }


    public int search2(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target)
            hi <<= 1;
        int lo = hi >> 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == reader.get(mid))
                return mid;
            else if (target < reader.get(mid))
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }

}
