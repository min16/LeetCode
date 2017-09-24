package array_string;
/**
 * Problem 387
 * ASCII size 256
 * char 크기를 이용
 */
public class FirstUniqueCharacterInString {
    public int firstUniqChar(String word) {
        int[] frequency = new int[256];

        for (int i = 0; i < word.length(); i ++) {
            frequency[word.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < word.length(); i ++) {
            if (frequency[word.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
