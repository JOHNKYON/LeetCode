package questions.leetcode692;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        Queue<Word> heap = new PriorityQueue<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word: map.keySet()) {
            heap.offer(new Word(word, map.get(word)));
        }

        List<String> res = new ArrayList<>();

        while(!heap.isEmpty() && k > 0) {
            res.add(heap.poll().word);
            k--;
        }
        return res;
    }

    private class Word implements Comparable<Word>{
        String word;
        int count;

        public Word(String w, int c) {
            word = w;
            count = c;
        }

        public int compareTo(Word x) {
            if (count == x.count)
                return word.compareTo(x.word);
            return x.count - count;
        }
    }
}
