package questions.leetcode857;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int num = quality.length;
        Worker[] workers = new Worker[num];

        for (int i=0; i<num; i++){
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        double ans = Double.MAX_VALUE;
        int sum = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Worker worker:workers) {
            heap.offer(-worker.quality);
            sum += worker.quality;
            if (heap.size() > K)
                sum += heap.poll();
            if (heap.size() == K)
                ans = Math.min(ans, sum*worker.ratio);
        }

        return ans;
    }

    private class Worker implements Comparable<Worker>{
        public int quality;
        public int wage;
        public double ratio;

        public Worker(int q, int w) {
            quality = q;
            wage = w;
            ratio = (double) w/q;
        }

        public int compareTo(Worker b) {
            return Double.compare(ratio, b.ratio);
        }
    }
}
