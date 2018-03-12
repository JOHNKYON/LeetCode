package questions.medianOfTwoSortedArrays;

/**
 * Created by JOHNKYON on 2018/3/12.
 * This is a solution to LeetCode Questions.
 */
public class MedianOfTwoSortedArrays {
    public double findMedian(int[] nums1, int[] nums2){
        /*The core of solving this problem is to use Bisection method
        * For two sequences A and B, after the cutting,
        * length(Left_A) + length(Left_B) = length(Right_A) + length(Right_B)
        * max(left) < min(right)
        * */

       //TODO: Not accepted by LeetCode so far
        int len1 = nums1.length, len2 = nums2.length;
        int total = len1 + len2;
        boolean flag = false;       //If total is even, flag is true, otherwise, flag is false.
        if (0 == total % 2){flag = true;}

//        Make sure that num1 points to the shorter one
        if (len1 > len2){
            int[] temp = nums2;
            int templen = len2;
            nums2 = nums1;
            nums1 = temp;
//            len2 = len1;
            len1 = templen;
        }
        int index1 = nums1.length-1;
        int index2;
        int midLen;
        if (flag) {midLen = total/2;}
        else {midLen = (total+1)/2;}
        index2 = midLen - index1-2;
        int left = 0, right = nums1.length-1;

        if (0 == len1 || nums1[right] < nums2[0] ){
//            Every elements in num1 is smaller than any element in num2
            if (flag){
//                Even
                if (index2 >= 0) {
                    return ((double) nums2[index2] + (double) nums2[index2 + 1]) / 2;
                }else {
                    return ((double) nums1[index1] + (double) nums2[index2 + 1]) / 2;
                }
            }else {
                return nums2[index2];
            }
        }else {
            int index1R = index1;   //For the first time run, the index1 is at the edge,so we have to set the bigger one
                                    //to make sure it doesn't go beyond the border.
            int index2R = index2 + 1;
            if (index2 < 0) { index2 = 0;}
            while (nums1[index1R] < nums2[index2] || nums2[index2R] < nums1[index1]){
                if (index1 == (left+right)/2){break;}
                index1 = (left+right)/2;
                if (nums1[index1R] < nums2[index2]){    //index1 is too small
                    left = index1;
                } else {                                //index1 is too big
                    right = index1;
                }
                index1R = index1 + 1;
                index2 = midLen - index1 - 2;
                index2R = index2 + 1;
            }
            if (flag){
                double small = Math.max(nums1[index1], nums2[index2]);
                double big = Math.min(nums1[index1R], nums2[index2R]);
                return (small + big)/2;
            }
            else {return Math.max(nums1[index1], nums2[index2]);}
        }
    }
}
