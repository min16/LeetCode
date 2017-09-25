package array_string;


/**
 * Problem 344
 */
public class ReverseString {
    public String reverseStringUsingSB(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseStringUsingChar(String s) {
        char[] word = s.toCharArray();
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            char temp = word[begin];
            word[begin] = word[end];
            word[end] = temp;
            begin ++;
            end --;
        }
        return new String(word);
    }

    public String reverseStringUsingByte(String s) {
        byte[] word = s.getBytes();
        int begin = 0, end = s.length() - 1;
        while (begin < end) {
            Byte temp = word[begin];
            word[begin] = word[end];
            word[end] = temp;
            begin ++;
            end --;
        }
        return new String(word);
    }

    public String reverseStringUsingXOR(String s) {
        char[] word = s.toCharArray();
        int begin = 0, end = word.length - 1;
        while (begin < end) {
            word[begin] = (char) (word[begin] ^ word[end]);
            word[end] = (char) (word[begin] ^ word[end]);
            word[begin] = (char) (word[begin] ^ word[end]);
            begin ++;
            end --;
        }
        return new String(word);
    }
}
