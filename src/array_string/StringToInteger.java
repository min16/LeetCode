package array_string;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StringToInteger {
    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MIN_VALUE;
    private static final int BOUND = MAX / 10;

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int len = str.length();
        int i = 0, sign = 1, total = 0;

        // skip leading white spaces
        while (i < len && str.charAt(i) == ' ') i++;

        // check plus or minus
        if (i < len && str.charAt(i) == '-' || str.charAt(i) == '+') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }

        // convert string to integer
        while (i < len) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) break;
            if (BOUND < total || BOUND == total && digit > 7) return sign == 1 ? MAX : MIN;
            total = 10 * total + digit;
            i++;
        }
        return total * sign;
    }

    @Test
    public void myAtoi() {
        assertEquals(1, myAtoi("1"));
        assertEquals(0, myAtoi(""));
        assertEquals(0, myAtoi(" "));
    }
    @Test
    public void checkSize() {
        assertEquals(0, new String("").length());
    }
}
