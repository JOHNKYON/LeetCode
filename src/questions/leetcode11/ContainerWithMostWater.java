package questions.leetcode11;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;

        while (right > left){
            if (height[left] < height[right]){
                int temp = height[left] * (right - left);
                res = (temp>res)? temp : res;
                left++;
            } else {
                int temp = height[right] * (right - left);
                res = (temp>res)? temp : res;
                right--;
            }
        }
        return res;
    }
}
