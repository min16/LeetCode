package math;

import org.junit.Assert;
import org.junit.Test;

/**
 * Problem 326
 */
public class PowerOfThree {
    public boolean isPowerOfThreeIterative(int n) {
        while (n > 1 && n % 3 == 0) n /= 3;
        return n ==1;
    }

    public boolean isPowerOfThreeRecurisve(int n) {
        return n > 0 && (n == 1 || (n%3 == 0 && isPowerOfThreeRecurisve(n/3)));
    }

    public boolean isPowerOfThreeMaxPow(int n) {
        int maxPowThree1 = (int) Math.pow(3, (int) (Math.log(0x7fffffff) / Math.log(3)));
        int maxPowThree2 = (int) Math.pow(3, (Math.log(0x7fffffff) / Math.log(3)));
        return (maxPowThree1 % n == 0);
    }

    public boolean isPowerOfThreeInteger(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    @Test
    public void test() {
        Assert.assertEquals(true, isPowerOfThreeMaxPow(27));
        Assert.assertEquals(false, isPowerOfThreeInteger(22));
        Assert.assertEquals(true, isPowerOfThreeIterative(27));
    }
}
