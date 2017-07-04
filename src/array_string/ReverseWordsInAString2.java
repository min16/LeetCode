package array_string;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReverseWordsInAString2 {
    private String reverseWords(String s) {
        char[] words = s.toCharArray();
        int len = words.length;

        reverse(words, 0, len - 1);
        for (int i = 0, j = 0; j <= len; j++) {
            if (j == len || words[j] == ' ') {
                reverse(words, i, j - 1);
                i = j + 1;
            }
        }
        return String.valueOf(words);
    }
    private void reverse(char[] words, int begin, int end) {
        while (begin < end) {
            char temp = words[begin];
            words[begin++] = words[end];
            words[end--] = temp;
        }
    }

    @Test
    public void reverseWordsInAString() {
        assertEquals("blue is sky the", reverseWords("the sky is blue"));
    }
}
