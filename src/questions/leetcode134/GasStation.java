package questions.leetcode134;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ptr = -1;
        int partialSum = 0;
        int sum = 0;
        for (int i=0; i<gas.length; i++) {
            sum += gas[i] - cost[i];
            partialSum += gas[i] - cost[i];
            if (ptr == -1 && gas[i] >= cost[i]) {
                ptr = i;
                partialSum = gas[i] - cost[i];
            }
            if (partialSum < 0)
                ptr = -1;
        }
        return (sum < 0)? -1: ptr;
    }
}
