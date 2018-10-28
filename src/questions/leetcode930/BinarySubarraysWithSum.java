package questions.leetcode930;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int count = 0;
        int temp = 0;

        if (S < 0 || A ==null || A.length == 0)
            return 0;
        int n =A.length;

        if (S != 0) {
            for (int left = 0, right = 0; right < n; ) {
                temp += A[right];
                if (temp < S) {
                    right++;
                    continue;
                }

                if (temp > S) {
                    while (left < right && temp > S) {
                        temp -= A[left++];
                    }
                }

                if (temp == S) {
                    int right2 = right + 1;
                    while (right2 < n && A[right2] == 0)
                        right2++;

                    int left2 = left;
                    while (left2 < right && A[left2] == 0)
                        left2++;

                    int left_c = left2 - left + 1;
                    int right_c = right2 - right;
                    count += left_c * right_c;

                    left = left2;
                    right = right2;
                }
            }
        } else {
            for (int left = 0, right = 0; right < n; ) {
                if (A[right] == 0) {
                    left = right;
                    while (right < n && A[right] == 0)
                        right++;
                    int len = right - left;
                    count += (len + 1) * len / 2;
                } else
                    right++;
            }
        }

        return count;
    }
}
