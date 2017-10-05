package math;

import java.util.HashSet;

/**
 * Problem 206
 */
public class HappyNumber {
    public HashSet<Integer> hashSet = new HashSet<>();
    public boolean isHappy(int n) {
        return calculate(n);
    }

    public boolean calculate(int n) {
        if (n == 1) return true;
        if(hashSet.contains(n)) return false;
        hashSet.add(n);

        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return calculate(sum);
    }
}
