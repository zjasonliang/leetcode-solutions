import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RemoveDuplicatesfromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode prev = head;
        ListNode current = prev.next;
        int val = prev.val;

        while (current != null) {
            if (current.val == val)
                current = current.next;
            else {
                val = current.val;
                prev = current;
                current = current.next;
            }
            prev.next = current;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        System.out.println(deleteDuplicates(head));
        System.out.println(1);

        LinkedList<Integer> list = new LinkedList <>();
        ArrayList<Integer> l = new ArrayList <>();

        Random r = new Random();

        r.nextInt(2);
    }
}
