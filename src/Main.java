import questions.medianOfTwoSortedArrays.MedianOfTwoSortedArrays;

public class Main {
    public static void main(String[] args){
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6};
        System.out.print(median.findMedian(nums1, nums2));
    }

}
