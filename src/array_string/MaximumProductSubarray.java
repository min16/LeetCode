package array_string;

/*
* Problem 152.
*/

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxCur = nums[0];
        int maxSoFar = nums[0];
        int minCur = nums[0];

        for (int i = 1; i < nums.length; i ++) {
            int maxCurPrev = maxCur;
            maxCur = Math.max(Math.max(nums[i], maxCur * nums[i]), minCur * nums[i]);
            minCur = Math.min(Math.min(nums[i], maxCurPrev * nums[i]), minCur * nums[i]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }

        return maxSoFar;
    }
}
