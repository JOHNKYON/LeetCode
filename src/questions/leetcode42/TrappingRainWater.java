package questions.leetcode42;

import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height){
        if (height.length == 0){
            return 0;
        }

        int left = 0, right = height.length-1, leftPeak = height[left], rightPeak = height[right], rain = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (height[left] > leftPeak) { leftPeak = height[left];}
                else {rain += leftPeak - height[left];}
                left++;
            } else {
                if (height[right] > rightPeak) {rightPeak = height[right];}
                else {rain += rightPeak - height[right];}
                right--;
            }
        }
        return rain;
    }
}
