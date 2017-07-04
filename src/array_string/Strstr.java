package array_string;

public class Strstr {
    private static final int NOT_FOUND = -1;
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return NOT_FOUND;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
}
