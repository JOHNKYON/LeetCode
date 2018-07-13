package questions.leetcode76;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Queue<Integer> heap = new PriorityQueue();
        Map<Character, Queue> hashmap = new HashMap<>();
        int min=-1;
        int left=0;

        for(char c : t.toCharArray()){
            if(!hashmap.containsKey(c)){
                hashmap.put(c, new PriorityQueue<Integer>());
            }
            hashmap.get(c).add(-1);
            heap.add(-1);
        }

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if (hashmap.containsKey(c)){
                Queue<Integer> q = hashmap.get(c);
                heap.remove(q.poll());
                heap.add(i);
                q.add(i);

                if(heap.peek() != -1){
                    int temp = i-heap.peek();
                    if (min==-1 || temp < min){
                        min = temp;
                        left = heap.peek();
                    }
                }
            }
        }

        return s.substring(left, left+min+1);
    }
}
