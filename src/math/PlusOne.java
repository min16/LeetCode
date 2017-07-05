package math;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[len + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    @Test
    public void plusOneTest() {
        assertArrayEquals(new int[]{9,8,7,6,5,4,3,2,1,1}, plusOne(new int[]{9,8,7,6,5,4,3,2,1,0}));
    }
}
