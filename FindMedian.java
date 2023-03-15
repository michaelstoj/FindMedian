/**
 * This class is used to find the median of an array
 * by utilizing a variation of the quicksort method (i.e. "quickselect").
 * Program: 2
 * @author: Connor Norris & Mike Stoj
 * @edu.uwp.cs.340.course.CSCI 340 - Data Structures and Algorithms
 * @edu.uwp.cs.340.assignment.Section 01
 * @bugs : None
 */
public class FindMedian {

    /**
     *  Finds the kth the smallest element in an unsorted array. Handles for both even and odd sized arrays.
     *  With even sized arrays, the median is the average of the two middle elements, so getMedian is called twice
     *  (Note: that it is the kth smallest element in the sorted order, not the kth distinct element.)
     * @param nums - the array of integers
     * @return median index value
     * @throws Exception
     */
    public static double findMedian(int[] nums) throws Exception {
        try {
            // find the index in the middle of the array
            int medianIndex = (nums.length / 2);
            int length = nums.length;

            // if indexVal > size of array --> throw exception
            if (nums == null || length == 0) {
                throw new Exception("index out of bounds"); // returns -1
            } else if(length % 2 == 0) {

                // if array is even, return the median of the two middle values
                double median1 = getMedian(nums, 0, nums.length - 1, medianIndex);
                double median2 = getMedian(nums, 0, nums.length - 1, medianIndex+1);
                System.out.println(median1 + " + " + median2);

                // return average of the two medians
                return (median1 + median2) / 2;
            } else {
                return getMedian(nums, 0, length - 1, medianIndex);// find the median index
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex); // print exception
        }
        return 0;
    }



    /**
     * This method iterates through the elements of the array and swaps the elements
     * using conditions to determine which side of the array to swap and guaranteeing that
     * upon completion, the pivot is in the correct position and all values on the left are less than
     * and all values on the right are greater than the pivot
     * @param nums
     * @param low - the low index of the array
     * @param high - the high index of the array
     * @return the index of the pivot
     */
    private static int quickSelect(int[] nums, int low, int high){

        // pivot is the last element in the array
        int pivot = nums[high];

        // set the left pointer to the low index
        int pivotIndex = low;

        // swap pivot with the first element in the array
        for (int i = low; i <= high; i++) {
            if (nums[i] < pivot) {

                int temp = nums[i];

                // swap first element in the array with the pivot
                nums[i] = nums[pivotIndex];
                // swap the pivot with the first element in the array
                nums[pivotIndex] = temp;

                pivotIndex++; // increment pivot index to the right
            }
        }

        // set temp to the last element in the array
        int temp = nums[high];
        // Last element in the array becomes pivotIndex
        nums[high] = nums[pivotIndex];
        // last element in the array becomes pivot
        nums[pivotIndex] = temp;
        // return pivotIndex
        return pivotIndex;
    }



    /**
     * This method is used to find the median of an array
     * Using recursion to sort from both the left and right sides of the array
     * @param nums  - the array of integers
     * @param low   - the low index of the array
     * @param high  - the high index of the array
     * @param k    - the index of the median
     * @return  the median index value
     */
    public static double getMedian(int[] nums, int low, int high, int k) {

        // partition the array around the pivot
        int partition = quickSelect(nums, low, high);

        // if partition is equal to k, return the pivot
        if (partition == k - 1) {
            return nums[partition]; // return the pivot
        } else if (partition < k - 1) {
            return getMedian(nums, partition + 1, high, k); // recursively call getMedian on the right side of the array
        } else {
            return getMedian(nums, low, partition - 1, k); // recursively call getMedian on the left side of the array
        }
    }
}

