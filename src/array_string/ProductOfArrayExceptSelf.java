package array_string;

/**
 * Problem 238
 */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] productExceptSelf = new int[size];
        for (int i = 0, beforeIndex = 1; i < size; i ++) {
            productExceptSelf[i] = beforeIndex;
            beforeIndex *= nums[i];
        }

        for (int i = size - 1, afterIndex = 1; i >= 0; i --) {
            productExceptSelf[i] *= afterIndex;
            afterIndex *= nums[i];
        }

        return productExceptSelf;
    }
}
