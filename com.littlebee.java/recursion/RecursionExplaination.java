public class RecursionExplaination {
    // To fully understand the recursion, you need to know the below example
    // How to get the max number in the array using the recursion.
    // 记住：能用recursion写出来的程序，也一定能用普通的方法写出来
    // get the max number from the an array, given an array of [L....R],find the max number from this array.
    // Master equation: T(N) = a * T(N / b) + O(N^d) a, b, c are constant
    // on th below algorithm, try to understand how does the recursion run through in the program, since when the recursion program run, there is a hidden stack in it.
    public int getMax(int[] nums) {
        return findMax(nums, 0, nums.length - 1);
    }

    private int findMax(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        } // 1. 写recursion的时候首先要先写出口表达式
        int mid = left + ((right - left) >> 1);
        int leftMax = findMax(nums, left, mid);
        int rightMax = findMax(nums, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }
}
