package questions.leetcode832;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {

        for (int i=0; i<A.length; i++){
            int left = 0;
            int right = A.length-1;
            while (left < right){
                int temp = 1 - A[i][left];
                A[i][left] = 1 - A[i][right];
                A[i][right] = temp;
                left++;
                right--;
            }

            if (left == right)
                A[i][left] = 1-A[i][left];
        }

        return A;
    }
}
