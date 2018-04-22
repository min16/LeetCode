package trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    public class TrieNode {
        Map<Character, TrieNode> children;
        int value;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            value = 0;
            isWord = false;
        }
    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
        }
        curr.isWord = true;
        curr.value = val;
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                return 0;
            }
            curr = next;
        }
        return getChildrenSum(curr);
    }

    private int getChildrenSum(TrieNode node) {
        int sum = 0;
        for (char c : node.children.keySet()) {
            sum += getChildrenSum(node.children.get(c));
        }
        return sum + node.value;
    }

    @Test
    public void testInsert() {
//        insert("aa", 3);
//        Assert.assertEquals(3, sum("a"));
//        insert("aa", 2);
//        Assert.assertEquals(2, sum("a"));
//        Assert.assertEquals(2, sum("aa"));
//        insert("aaa", 3);
//        Assert.assertEquals(3, sum("aaa"));
        Assert.assertEquals(0, sum("bbb"));
    }

}
