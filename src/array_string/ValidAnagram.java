package array_string;

/**
 * Problem 242
 */
public class ValidAnagram {
    // 5ms
    public boolean isValidAnagram(String s, String t) {
        int[] word = new int[26];

        int sSize = s.length();
        int tSize = t.length();

        if (sSize != tSize) return false;

        for(int i = 0; i < sSize; i ++) {
            word[s.charAt(i) - 'a'] ++;
        }

        for(int i = 0; i < tSize; i ++) {
            word[t.charAt(i) - 'a'] --;
        }

        for (int count : word) {
            if (count != 0) return false;
        }
        return true;
    }

    // 3ms
}
