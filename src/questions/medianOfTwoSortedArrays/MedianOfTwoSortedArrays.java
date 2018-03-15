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

       //TODO: Need to re-construct the code. The code is like shit now.
        int len1 = nums1.length, len2 = nums2.length;
        int total = len1 + len2;
        boolean flag = false;       //If total is even, flag is true, otherwise, flag is false.
        if (0 == total % 2){flag = true;}

//        Make sure that num1 points to the shorter one
        if (len1 > len2){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
//            len2 = len1;
            len1 = len2;
        }

        int index2;
        int midLen;
        if (flag) {midLen = total/2;}
        else {midLen = (total+1)/2;}
        int left = 0, right = nums1.length;
        int index1 = (left + right) / 2;
        index2 = midLen - index1;


        if (0 == len1 || nums1[right-1] < nums2[0] ){
//            Every elements in num1 is smaller than any element in num2 or num1 is empty.
            if (flag){
//                Even
                if (midLen - len1 > 0) {
                    return ((double) nums2[midLen - len1 -1] + (double) nums2[midLen - len1]) / 2;
                }else {
                    if (0 == len1) {
                        return (double) 0;
                    }else {
                        return ((double) nums2[0] + (double) nums1[len1-1]) / 2;
                    }
                }
            }else {
                return nums2[midLen-len1-1];
            }
        }else {
            int index1L = index1 - 1;
            if (0 == index1) {
                index1L = index1;   //For the first time run, the index1 is at the edge,so we have to set the bigger one
                //to make sure it doesn't go beyond the border.
            }
            int index2R = index2;
            if (index2 == nums2.length){
                index2R = index2-1;
            }
//            if (0 == index2) { index2L = 0;}
            while (nums1[index1] < nums2[index2-1] || nums2[index2R] < nums1[index1L]){
                if (nums1[index1] < nums2[index2-1]){       //Index1 is too small
                    if (index1 == len1){                    //All elements in num1 are in the smaller set
                        if (flag){
                            double small = Math.max(nums1[index1-1], nums2[index2-1]);
                            double big;
                            if (index1 == nums1.length){                //All elements in num1 are in the smaller set
                                big = nums2[index2];
                            }else {
                                big = Math.min(nums1[index1], nums2[index2R]);
                            }
                            return (small + big)/2;
                        }
                        else {return Math.max(nums1[index1L], nums2[index2-1]);}
                    }else {
                        left = index1;
                        if (index1 == (left+right+1)/2){break;}
                        index1 = (left + right + 1) / 2;
                    }
                } else {                                    //Index1 is too big
                    if (0 == index1){
                        if (flag){
//                Even
                            if (index2 == nums2.length || nums2[index2] > nums1[index1]) {
                                return ((double) nums2[index2-1] + (double) nums1[index1]) / 2;
                            }else {
                                return ((double) nums2[index2-1] + (double) nums2[index2]) / 2;
                            }
                        }else {
                            return nums2[index2-1];
                        }
                    }
                    right = index1;
                    if (index1 == (left+right)/2){break;}
                    index1 = (left + right) / 2;
                }
                index1L = index1-1;
                index2 = midLen - index1;
                index2R = index2;
                if (0 == index1) {                           //All elements in num1 are in the bigger set
                    if (flag){
//                Even
                        if (index2 == nums2.length || nums2[index2] > nums1[index1]) {
                            return ((double) nums2[index2-1] + (double) nums1[index1]) / 2;
                        }else {
                            return ((double) nums2[index2-1] + (double) nums2[index2]) / 2;
                        }
                    }else {
                        return nums2[index2-1];
                    }
                } else if (index1 == len1){                    //All elements in num1 are in the smaller set
                    if (flag){
                        double small = Math.max(nums1[index1-1], nums2[index2-1]);
                        double big;
                        if (index1 == nums1.length){                //All elements in num1 are in the smaller set
                            big = nums2[index2];
                        }else {
                            big = Math.min(nums1[index1], nums2[index2R]);
                        }
                        return (small + big)/2;
                    }
                    else {return Math.max(nums1[index1L], nums2[index2-1]);}
                }
            }
            if (0 == index1) {                           //All elements in num1 are in the bigger set
                if (flag){
//                Even
                    if (index2 == nums2.length || nums2[index2] > nums1[index1]) {
                        return ((double) nums2[index2-1] + (double) nums1[index1]) / 2;
                    }else {
                        return ((double) nums2[index2-1] + (double) nums2[index2]) / 2;
                    }
                }else {
                    return nums2[index2-1];
                }
            } else if (index1 == len1){                    //All elements in num1 are in the smaller set
                if (flag){
                    double small = Math.max(nums1[index1-1], nums2[index2-1]);
                    double big;
                    if (index1 == nums1.length){                //All elements in num1 are in the smaller set
                        big = nums2[index2];
                    }else {
                        big = Math.min(nums1[index1], nums2[index2R]);
                    }
                    return (small + big)/2;
                }
                else {return Math.max(nums1[index1L], nums2[index2-1]);}
            }
            if (flag){
                double small = Math.max(nums1[index1L], nums2[index2-1]);
                double big;
                if (index1 == nums1.length){                //All elements in num1 are in the smaller set
                    big = nums2[index2R];
                }else {
                    big = Math.min(nums1[index1], nums2[index2R]);
                }
                return (small + big)/2;
            }
            else {return Math.max(nums1[index1L], nums2[index2-1]);}
        }
    }
}
