package questions.codility;

public class Codility {
    public int firstMissing(int[] A){

//        Sort by putting element into right position
        for (int i = 0; i < A.length; i++){
            while ((A[i] > 0) && (A[i] < A.length) && (A[i] -1 != i) && (A[A[i]-1] != A[i])){
                swap(A, A[i]-1, i);
            }
        }

//        Check the first missing value
        int i = 0;
        for (; i < A.length; i++){
            if (A[i] != i+1){ break;}
        }
        return i+1;
    }

     private void swap(int[] A, int a, int b){
//        Swap element in array at position a and b.
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
