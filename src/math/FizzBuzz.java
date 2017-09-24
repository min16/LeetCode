package math;
import java.util.*;
/**
 * Problem 412
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= N; i ++) {
            list.add(printFizzBuzz(i));
        }
        for (String i : list) {
            System.out.println(i);
        }
    }

    private static String printFizzBuzz(int num) {
        String str = "";
        if (num % 15 == 0) return "Fizz Buzz";
        else if (num % 3 == 0) return "Fizz";
        else if (num % 5 == 0) return"Buzz";
        else return "" + num;
    }
}
