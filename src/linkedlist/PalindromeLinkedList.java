package linkedlist;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        // locate fast at the end and slow in middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse 2nd list
        slow = reverse(slow);
        fast = head;

        // compare 1st list and 2nd list
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(0);
        ListNode current = head;
        current.next = new ListNode(0);
        current = current.next;
        assertEquals(true, isPalindrome(head));
    }
}
