package array_string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        Set<Character> jewelsSet = new HashSet<>();
        for (char c : J.toCharArray()) {
            jewelsSet.add(c);
        }

        for (char c : S.toCharArray()) {
            if (jewelsSet.contains(c)) {
                cnt ++;
            }
        }

        return cnt;
    }
}
