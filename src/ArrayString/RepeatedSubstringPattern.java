package ArrayString;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length(), i = len / 2;
        if (len == 1) return false;
        while (i > 0) {
            if (len % i == 0) {
                if(isRepeat(s, i, len)) return true;
            }
            i--;
        }
        return false;
    }
    public boolean isRepeat(String s, int repeatLen, int len) {
        for (int i = 0; i < len - repeatLen; i++) {
            if (s.charAt(i) != s.charAt(i + repeatLen)) return false;
        }
        return true;
    }
}
