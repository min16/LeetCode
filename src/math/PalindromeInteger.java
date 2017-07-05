package math;

public class PalindromeInteger {
    public boolean isPalindromeDiv (int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x != 0) {
            int begin = x / div;
            int end = x % 10;
            if (begin != end) return false;
            x = x % div / 10;
            div /= 100;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false;
        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return (x == num || x == num / 10);
    }
}
