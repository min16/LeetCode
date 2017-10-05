package array_string;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 217
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int size = nums.length;
        if (size < 2) return false;
        Set<Integer> set = new HashSet<Integer>();
        for (int number : nums) {
            if (set.contains(number)) return true;
            set.add(number);
        }
        return false;
    }
}
