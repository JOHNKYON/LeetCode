package questions.leetcode621;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0)  return 0;

        int[] counts = new int[26];

        int max = 0;
        for (char c : tasks){
            int index = c - 'A';
            counts[index] += 1;
            max = Math.max(max, counts[index]);
        }

        max--;
        int idle = max * (n+1);
        for (int i : counts){
            idle -= Math.min(i, max);
        }

        return (idle > 0)? (idle + tasks.length) : tasks.length;
    }
}
