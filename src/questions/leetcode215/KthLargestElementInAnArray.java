package questions.leetcode215;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue heap = new PriorityQueue<Integer>(myComparator);
        int curr = 0;

        while(heap.size() < k){
            heap.add(nums[curr]);
            curr++;
        }
        while(curr < nums.length){
            if(nums[curr] > (int)heap.peek()){
                heap.poll();
                heap.add(nums[curr]);
            }
            curr++;
        }

        return (int)heap.peek();
    }

    private Comparator<Integer> myComparator = new Comparator<Integer>(){

        @Override
        public int compare(Integer i1, Integer i2){
            return (int)i1-i2;
        }
    };
}
