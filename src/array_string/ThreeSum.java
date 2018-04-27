package array_string;

/*
* Problem 15.
* 3Sum
* pointer, no duplicate
*/

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int index = 0; index < nums.length - 2; index ++) {
            int num = nums[index];
            int targetSum = 0 - num;
            int left = index + 1;
            int right = nums.length - 1;

            if (index != 0 && num == nums[index - 1]) {
                continue;
            }

            while (left < right) {
                int currSum = nums[left] + nums[right];

                if (currSum == targetSum) {
                    result.add(Arrays.asList(num, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    left ++;
                    right --;
                } else if (currSum < targetSum) {
                    left ++;
                } else {
                    right --;
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        threeSum(new int[]{-2,0,0,2,2});
    }
}
