package com.littlebee.binarysearch;;

/** HARD LeetCode 410
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
 *
 * Return the minimized largest sum of the split.
 *
 * A subarray is a contiguous part of the array.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        // find the smallest number to make sure the subarray value must greater than that
        int len = nums.length;
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (len == k) return max;
        if (k == 1) return sum;
        // search interval will between max and sum
        int left = max;
        int right = sum;
        int ans = max;
        // find the number of subarrays that is less than the k total subarrays, so the value could be the answer
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getNumberOfSubarrays(mid, nums) <= k) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int getNumberOfSubarrays(int val, int[] nums) {
        int count = 1;
        int tempSum = 0;
        for (int num : nums) {
            if (tempSum + num > val) {
                count++;
                tempSum = 0;
            }
            tempSum += num;
        }
        return count;
    }
}
