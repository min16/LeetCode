package ArrayString;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = new ReverseWordsInAString().reverseWords("abc ab");
        System.out.println(s);
    }

    public String reverseWordsRegex(String s) {
        String[] parts = s.split("\\s+");
        String reverse = "";
        for (int i = parts.length - 1; i >= 0; i--) {
            reverse += parts[i] + " ";
        }
        return reverse.trim();
    }

    public String reverseWords(String s) {
        char[] words = s.toCharArray();
        int n = words.length - 1;

        // 1. reverse whole words
        reverse(words, 0, n);
        // 2. reverse each word
        reverseWord(words, n);
        // 3. clean space
        return cleanSpaces(words, n);
    }

    public void reverse(char[] a, int i, int j) {
        while (i < j) {
            char c = a[i];
            a[i++] = a[j];
            a[j--] = c;
        }
    }

    public void reverseWord(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++;
            while (j < i || j < n && a[j] != ' ') j++;
            reverse(a, i, j - 1);
        }
    }

    public String cleanSpaces(char[] a, int n) {
        int index = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && a[i] == ' ' && a[i - 1] == ' ') continue;
            a[index++] = a[i];
        }
        return String.valueOf(a);
    }

    @Test
    public void testReverseWord() {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        //assertEquals("ba cba", reverseWordsInAString.reverseWord("ab abc".toCharArray(), 6));
    }
    @Test
    public void testCleanSpaces() {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        assertEquals("a b c", cleanSpaces("   a b  c ".toCharArray(), "   a b  c ".length()));
    }
}
