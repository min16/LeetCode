package array_string;

import java.util.*;
/**
 * problem 350
 * hashmap에 없는 key를 호출하면 null return
 * if (null) -> null pointer exception
 */
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
       HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums1) {
            count.computeIfPresent(num, (K, V) -> V += 1);
            count.putIfAbsent(num, 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (count.containsKey(num) && count.get(num) > 0) {
                result.add(num);
                count.compute(num, (K, V) -> V -= 1);
            }
        }

        int[] intersect = new int[result.size()];
        for (int i = 0; i < intersect.length; i ++) {
            intersect[i] = result.get(i);
        }
        return intersect;
    }
}
