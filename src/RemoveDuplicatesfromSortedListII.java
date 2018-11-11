import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesfromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        ListNode pre = dummyHead;
        pre.next = head;

        // 1->2->3->3->4->4->5
        ListNode begin = pre.next;
        ListNode end = begin;

        while (end != null) {

            while (end.next != null && end.next.val == end.val)
                end = end.next;

            if (begin == end) {
                pre.next = begin;
                pre = pre.next;
                begin = end = pre.next;
            } else {
                begin = end = end.next;
            }
        }

        pre.next = null;
        return dummyHead.next;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        System.out.println(deleteDuplicates(head));
        System.out.println(1);
    }
}
