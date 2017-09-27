package array_string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
/**
 * problem 350
 * hashmap에 없는 key를 호출하면 null return
 * if (null) -> null pointer exception
 */
public class IntersectionOfTwoArrays2 {
    public int[] intersectHM(int[] nums1, int[] nums2) {
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

    public int[] intersectionTP(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int num1 = 0, num2 = 0 ;
        int nums1Size = nums1.length;
        int nums2Size = nums2.length;

        ArrayList<Integer> answer = new ArrayList<>();
        while (num1 < nums1Size && num2 < nums2Size) { // 반복된 함수 호출?
            if (nums1[num1] == nums2[num2]) {
                answer.add(nums1[num1]);
                num1 ++;
                num2 ++;
            } else if (nums1[num1] < nums2[num2]) {
                num1 ++;
            } else {
                num2 ++;
            }
        }
        int answerSize = answer.size();
        int[] intersection = new int[answerSize];
        for (int i = 0; i < answerSize; i ++) {
            intersection[i] = answer.get(i);
        }

        return intersection;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2, 2}, intersectionTP(new int[]{0, 2, 2, 1}, new int[]{2, 2}));
    }
}

