package array_string;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        int num = N;
        int endIndexOfIncreasingDigit = getEndIndexOfIncreasingDigit(num);
        while (endIndexOfIncreasingDigit != 0) {
            int increasingDigits = getIncreasingDigits(num, endIndexOfIncreasingDigit);
            num = increasingDigits - 1;
            endIndexOfIncreasingDigit = getEndIndexOfIncreasingDigit(num);
        }
        return num;
    }
    /*
    * get increasing digits of N
    */
    private int getIncreasingDigits(int N, int index) {
        int digit = (int) Math.pow(10, index);
        return N / digit * digit;
    }
    /*
    * get end index of increasing digits
    */
    private int getEndIndexOfIncreasingDigit(int N) {
        String stringN = String.valueOf(N);
        int i = 0;
        int length = stringN.length();
        while (i < length - 1) {
            if (stringN.charAt(i) > stringN.charAt(i + 1)) {
                break;
            }
            i ++;
        }
        return length - i - 1;
    }

    @Test
    public void testGetIncreasingIndex() {
        assertEquals(1, getEndIndexOfIncreasingDigit(10));
        assertEquals(3, getEndIndexOfIncreasingDigit(9822));
        assertEquals(2, getEndIndexOfIncreasingDigit(1209));
        assertEquals(0, getEndIndexOfIncreasingDigit(1234));
    }

    @Test
    public void testGetIncreasingDigits() {
        assertEquals(10, getIncreasingDigits(10, 1));
        assertEquals(9000, getIncreasingDigits(9822, 3));
        assertEquals(1200, getIncreasingDigits(1209, 2));
        assertEquals(1234, getIncreasingDigits(1234,0));
    }

    @Test
    public void testMonontoneIncreasingDigits() {
        assertEquals(9, monotoneIncreasingDigits(10));
        assertEquals(1234, monotoneIncreasingDigits(1234));
        assertEquals(299, monotoneIncreasingDigits(332));
    }
}
