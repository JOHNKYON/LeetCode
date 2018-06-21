package questions.leetcode218;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem {

    public List<int[]> getSkyline(int[][] buildings){
        List<int[]> skyline = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        for (int[] building : buildings){
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }

        heights.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        Queue<Integer> heap = new PriorityQueue<>((a, b)-> (b-a));

        heap.offer(0);
        int prev = 0;

        for (int[] dot : heights){
            if (dot[1] < 0) heap.offer(-dot[1]);
            else heap.remove(dot[1]);

            int cur = heap.peek();
            if (prev != cur){
                skyline.add(new int[]{dot[0], cur});
                prev = cur;
            }
        }

        return skyline;
    }
}
