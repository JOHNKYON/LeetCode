package questions.leetcode941;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;
        boolean up = true;
        for (int i=1; i<A.length; i++) {
            if (i == 1 && A[i] <= A[i-1])
                return false;
            if (A[i] == A[i-1])
                return false;
            if (A[i] < A[i-1])
                up = false;
            if (!up && A[i] > A[i-1])
                return false;
        }
        return !up;
    }
}
