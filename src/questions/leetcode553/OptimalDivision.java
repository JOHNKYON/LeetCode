package questions.leetcode553;

public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        if (nums.length < 1) return "";
        StringBuilder largestResult = new StringBuilder();
        largestResult.append(nums[0]);

        if (nums.length == 1) return largestResult.toString();
        largestResult.append("/");
        for (int i = 1; i < nums.length; i++ ) {
            if(i == 1 && i != nums.length - 1) {
                largestResult.append("(");
            }
            largestResult.append(nums[i]);

            if (i != 1 && i == nums.length - 1) {
                largestResult.append(")");
            } else {
                if(i == 1 && i == nums.length - 1) break;
                largestResult.append("/");
            }
        }

        return largestResult.toString();
    }
}
