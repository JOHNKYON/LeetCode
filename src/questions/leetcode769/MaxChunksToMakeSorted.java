package questions.leetcode769;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int start = 0;
        int smallest = Integer.MAX_VALUE;
        int largest = 0;
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
            smallest = Math.min(smallest, arr[i]);
            if (start == smallest && i == largest) {
                count++;
                start = i+1;
                smallest = Integer.MAX_VALUE;
                largest = 0;
            }
        }
        return count;
    }
}
