package questions.leetcode146;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by JOHNKYON on 2018/4/9.
 * This is a solution to LeetCode Questions.
 */
public class LRUCache {
    private LinkedList<Node> cache;
    private HashMap<Integer, Node> map;      //key index
    private int capacity;

    private class Node{
        int key;
        int value;


        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedList<Node>();
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {return -1;}
        else {
            cache.remove(map.get(key));
            cache.push(map.get(key));
            return cache.get(0).value;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (!map.containsKey(key)){
            if (cache.size() >= capacity) {
                map.remove(cache.pollLast().key);
            }
            map.put(key, node);
            cache.push(node);
        } else {
            cache.remove(map.get(key));
            map.put(key, node);
            cache.push(node);
        }
    }

}
