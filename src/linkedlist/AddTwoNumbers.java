package linkedlist;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead, p = l1, q = l2;
        int sum = 0;

        while (p != null || q != null) {
            sum /= 10;
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (sum >= 10) curr.next = new ListNode(1);
        return dummyHead.next;
    }
}
