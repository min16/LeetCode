package array_string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Problem 283
 */
public class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        int left = 0, right = 1;
        if (nums.length == 1) return nums;
        while(left < nums.length -1 && right < nums.length) {
            if (nums[left] == 0) {
                while (nums[right] == 0) {
                    right++;
                    if (right == nums.length) return nums;
                }
                swap(left, right, nums);
            } else {
                left++;
                right++;
            }
        }
        return nums;
    }
    private void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(moveZeroes(new int[]{0, 1, 0, 3, 12}), new int[]{1, 3, 12, 0, 0});
    }
}
