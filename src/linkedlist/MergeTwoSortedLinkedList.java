package linkedlist;

public class MergeTwoSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode p;
        if (l1.val < l1.val) {
            p = l1;
            p.next = mergeTwoLists(l1.next, l2);
        }
        else {
            p = l2;
            p.next = mergeTwoLists(l1, l2.next);
        }
        return p;
    }
}
