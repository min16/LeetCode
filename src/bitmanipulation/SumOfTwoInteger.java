package bitmanipulation;
import java.util.*;
/**
 * problem 371
 * Sum of Two Integer
 */
public class SumOfTwoInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        //sum
        getSum(a, b);
    }

    private static int getSum(int a, int b) {
        int result = a ^ b;
        int carry = (a & b) << 1;
        result += carry;
        //int result = ((a ^ b) + ((a & b) << 1));
        // return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
        return result;
    }
}
