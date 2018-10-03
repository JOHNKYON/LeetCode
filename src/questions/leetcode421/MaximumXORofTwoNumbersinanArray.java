package questions.leetcode421;

public class MaximumXORofTwoNumbersinanArray {
    public int findMaximumXOR(int[] nums) {
        TreeNode root = new TreeNode(0);
        int max = findMax(nums);
        int maxBit = 32 - Integer.numberOfLeadingZeros(max);
        //build prefix tree
        TreeNode currNode = root;
        for (int i = 0; i < nums.length; i++) {
            for (int j = maxBit -1; j >=0 ; j--) {
                int tmp = (nums[i] >>j)& 1;
                if(tmp == 0)
                {
                    if(currNode.left == null)
                    {
                        currNode.left = new TreeNode(0);
                    }
                    currNode = currNode.left;
                }else {
                    if(currNode.right == null)
                    {
                        currNode.right = new TreeNode(1);
                    }
                    currNode = currNode.right;
                }
            }
            // finished for nums[i], will do it for nums[i++];
            currNode = root;
        }

        //find max xor value
        int maxXOR = 0;

        for (int i = 0; i < nums.length; i++) {
            int res = 0;
            for (int j = maxBit -1; j >=0; j--) {
                int tmp = (nums[i] >>j)& 1;
                if(currNode.left != null && currNode.right != null)
                {
                    if(tmp == 0)
                    {
                        currNode = currNode.right;
                    }else {
                        currNode = currNode.left;
                    }
                }else {
                    currNode = currNode.left == null ? currNode.right : currNode.left;
                }

                res += (tmp^currNode.val) << j;
            }
            currNode = root;
            maxXOR = maxXOR > res ? maxXOR : res;
        }
        return maxXOR;
    }
    private int findMax(int[] nums)
    {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max)
            {
                max = nums[i];
            }
        }
        return max;
    }
    private static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val)
        {
            this.val = val;
        }
    }
}
