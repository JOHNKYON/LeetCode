package questions.leetcode703;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinaStream {
    Queue<Integer> queue;
    int capability;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        capability = k;
        for (int i=0; i<nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > capability) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > capability)
            queue.poll();
        return queue.peek();
    }
}
