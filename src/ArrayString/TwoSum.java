package ArrayString;

import java.util.HashMap;

public class TwoSum {
    //Brute Force
    public static int[] twoSumBF(Integer[] array, Integer target) {
        int sum;
        int size = array.length;
        for(int i = 0; i < size-1; i++) {
            for(int j = i+1; j < size; j++) {
                sum = array[i] + array[j];
                if(sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    //assume array is ascend
    public int[] twoSumLF(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int sum;
        while(left != right) {
            sum = nums[left] + nums[right];
            if(target == sum) return new int[]{left, right};
            else if(target > sum) {
                left++;
                continue;
            }
            else {
                right--;
                continue;
            }
        }
        return new int[2];
    }
    //HashMap
    public int[] twoSumHM(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            int key1 = nums[i];
            if(map.containsKey(target - key1)) return new int[]{i, map.get(target - key1)};
            map.put(key1, i);
        }
        return new int[2];
    }
}
