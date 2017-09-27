package bitmanipulation;
import java.util.*;
/**
 * problem 371
 * Sum of Two Integer
 */
public class SumOfTwoInteger {

    private static int getSumRecursive(int a, int b) {
        if (b == 0) return a;
        return getSumRecursive(a ^ b, (a & b) << 1);
    }

    private static int getSumInterative(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
