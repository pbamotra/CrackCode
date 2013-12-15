package LinkedListCycle;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/15/13
 * Time: 3:27 PM
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        boolean hasCycle = false;
        if (head == null) return false;
        if (head.next == null) return false;
        if (head.next.next == null) return false;
        while (true) {
            p = p.next;
            q = q.next;
            if (q == null) return false;
            q = q.next;
            if (q == null) return false;
            if (p == q) {
                hasCycle = true;
                break;
            }
        }

        return hasCycle;

    }

}
