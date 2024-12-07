package com.littlebee.binarysearch;;

/**
 * LeetCode 875 Question Description:
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        // koko eating one pile can take more than 1 hour, e.g. 30 can be eating 15 bananas every hour
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile); // koko at least eats the  bananas of the smallest array number
        }
        // low and high represents the speed of koko's banana eating
        int low = 1;
        int high = max;
        int ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (kokospeed(mid, h, piles)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean kokospeed(int speed, int timelimit, int[] piles) {
        int totalHours = 0;
        for (int pile : piles) {
            if (speed > pile) totalHours++;
            else {
                totalHours += pile % speed == 0 ? pile / speed : pile / speed + 1;
            }
            // totalHours += (pile + speed - 1) / speed; 这是一种向上算整除的方法。面试中不一定需要知道
            if (totalHours > timelimit) return false; // !!!!!!这个才是代码出问题的地方，这样做事避免超时
            /*
                piles = [805306368,805306368,805306368]
                h = 1000000000 不加的话这个例子过不去
            */
        }
        return totalHours <= timelimit;
    }
}
