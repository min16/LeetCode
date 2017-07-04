package array_string;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ValidPalindrome {
    public boolean isPalindromeCharacterOperation(String s) {
        int size = s.length();
        if (size == 0) return true;
        int left = 0, right = size - 1;
        char[] chars = s.toCharArray();

        while (left < right) {
            if(!Character.isLetterOrDigit(chars[left])) left++;
            else if(!Character.isLetterOrDigit(chars[right])) right--;
            else if(Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        s = s.trim().replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        if (s.length() == 0) return true;
        char[] chars = s.toCharArray();
        for(int i = 0, j = chars.length - 1; i < j;) {
            if(chars[i++] != chars[j--]) return false;
        }
        return true;
    }

    public boolean isPalindromeTemp(String s) {
        char[] words = s.toCharArray();
        int len = words.length;
        int i = 0, j = len - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(words[i])) i++;
            else if (!Character.isLetterOrDigit(words[j])) j--;
            else if (words[i] != words[j]) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(true, isPalindromeTemp(".,"));
    }
}
