package array_string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Problem 283
 */
public class MoveZeroes {
    public int[] moveZeroesSwap(int[] nums) {
       for (int i = 0, currentIndex = 0; i < nums.length; i ++) {
           if (nums[i] != 0) {
               nums[currentIndex ++] = nums[i];
               nums[i] = 0;
           }
       }
        return nums;
    }

    public int[] moveZeroesInsertion(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) nums[index++] = num;
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
        return nums;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, moveZeroesSwap(new int[]{0, 1, 0, 3, 12}));
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, moveZeroesInsertion(new int[]{0, 1, 0, 3, 12}));
    }
}
