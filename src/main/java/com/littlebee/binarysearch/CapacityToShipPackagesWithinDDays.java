package com.littlebee.binarysearch;;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        int ans = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]); //!!!!! Do you know why removing this will be wrong:
            // Removing this line could lead to incorrect results because the binary search would consider weight capacities that are too small to carry the heaviest item,
            // which is invalid.
        }
        // 找最小的左边界
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int reqdays = getDays(mid, weights);
            if (reqdays <= days) {
                // decrease the weight, but could be the answer
                high = mid - 1;
                ans = mid; // !!!!!record the answer here. high = mid - 1 is to make sure the while loop have a exit point. I revisited this question, and always bind my mind to whether i need to write high = mid or high = mid - 1, if left <= right, then high = mid - 1, otherwise, it will not end the loop and become infinity
            } else {
                // increase the weight
                low = mid + 1; // floor the left, for example, left = 5.5, then answer will be 5
            }
        }
        return ans;
    }

    private int getDays(int val, int[] weights) {
        int days = 1;
        int totalWeight = 0;
        for (int wt : weights) {
            if (totalWeight + wt > val) {
                days++;
                totalWeight = 0;
            }
            totalWeight += wt;
        }
        return days;
    }
}

