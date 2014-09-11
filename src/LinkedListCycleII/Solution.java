package LinkedListCycleII;

import Tools.ListNode;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 8:30 PM
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;

        }
        ListNode p = head;
        ListNode q = head;
        while (true) {
            p = p.next;
            q = q.next.next;

            if (q == null || q.next == null) {
                return null;
            }

            if (p == q) {
                break;
            }
        }

        p = head;
        while (true) {
            if (q == p) {
                return p;
            }
            p = p.next;
            q = q.next;

        }

    }
}