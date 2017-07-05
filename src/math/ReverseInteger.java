package math;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReverseInteger {
    public int reverse(int x) {
        int total = 0;
        while (x != 0) {
            int tail = x % 10;
            if (((Integer.MAX_VALUE - Math.abs(tail)) / 10) < Math.abs(total)) return 0;
            total = total * 10 + tail;
            x /= 10;
        }
        return total;
    }

    public int reverseLong(int x) {
        long total = 0;
        while (x != 0) {
            total = total * 10 + x % 10;
            x /= 10;
            if (Integer.MAX_VALUE < total || Integer.MIN_VALUE > total) return 0;
        }
        return (int) total;
    }

    public int reverseNewResult(int x) {
        int total = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = total * 10 + tail;
            if ((newResult - tail) / 10 != total) return 0;
            total = newResult;
            x /= 10;
        }
        return total;
    }


    @Test
    public void test() {
        assertEquals(0, reverse(214748364));
    }
}
