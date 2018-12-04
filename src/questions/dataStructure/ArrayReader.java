package questions.dataStructure;

public class ArrayReader {
    int[] nums;

    public ArrayReader(int[] arr) {
        nums = arr;
    }

    public int get(int index) {
        if (index >= nums.length)
            return Integer.MAX_VALUE;
        return nums[index];
    }
}
