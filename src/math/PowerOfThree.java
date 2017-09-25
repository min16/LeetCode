package math;

/**
 * Problem 326
 */
public class PowerOfThree {
    public boolean isPowerOfThreeIterative(int n) {
        if (n > 1) {
            while (n % 3 == 0) n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThreeRecurisve(int n) {
        return n > 0 && (n == 1 || (n%3 == 0 && isPowerOfThreeRecurisve(n/3)));
    }
}
