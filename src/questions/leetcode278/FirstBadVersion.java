package questions.leetcode278;

public class FirstBadVersion {
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 0, right = n;
            while (left < right){
                // Watch out the overflow
                int mid = left + (right - left)/2;
                boolean curr = isBadVersion(mid);

                if (curr)   right = mid;
                else    left = mid+1;
            }
            return left;
        }
    }

    private class VersionControl{
        protected boolean isBadVersion(int i){
            return true;
        }
    }
}
