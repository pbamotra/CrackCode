package SwapNodesInPairs;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/18/13
 * Time: 8:17 PM
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode now = head;
        head = head.next;
        while (now != null) {
            if (now.next == null) break;
            ListNode p = now;
            ListNode q = now.next;
            p.next = q.next;
            q.next = p;
            now = p.next;
        }
        return head;
    }
}
