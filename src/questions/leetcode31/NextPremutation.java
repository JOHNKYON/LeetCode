package questions.leetcode31;

public class NextPremutation {
    public void nexPermutation(int[] nums){
        boolean sorted = false;

        if (nums.length <= 1){return;}
        for (int i = nums.length-1; i > 0 ; i--){
            if (nums[i] > nums[i-1]){
                int j = i;
                while (j < nums.length && nums[j] >nums[i-1]){
                    j++;
                }
//                swap
                int temp = nums[i-1];
                nums[i-1] = nums[j-1];
                nums[j-1] = temp;
//                sort
//                quickSort(nums, i, nums.length-1);

//                reverse
                reverve(nums, i, nums.length-1);

                sorted = true;
                break;
            }
        } if (!sorted){
//            quickSort(nums, 0, nums.length-1);
            reverve(nums, 0, nums.length-1);
        }
    }

    private  void reverve(int[] nums, int head, int tail){
        int half = (tail - head)/2;
        for (int k = 0; k <= half; k++){
            int temp = nums[head+k];
            nums[head+k] = nums[tail-k];
            nums[tail-k] = temp;
        }
    }

    private void quickSort (int[] nums, int head , int tail){
        if (head >= tail || nums == null || nums.length <= 1){
            return;
        }
        int i = head, j =tail, pivot = nums[(head+tail)/2];
        while (i <= j){
            while (nums[i] < pivot){
                i++;
            } while (nums[j] > pivot){
                j--;
            } if (i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            } else if (i == j){
                i++;
            }
        }
        quickSort(nums, head, j);
        quickSort(nums, i, tail);
    }

}
