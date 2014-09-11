package RemoveDuplicatesFromSortedList;

import Tools.ListNode;
import Tools.NodeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 10:53 AM
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        while (true) {
            while (p.val == q.val) {
                q = q.next;
                p.next = q;
                if (q == null) return head;
            }
            while (p.val != q.val) {
                p = p.next;
                q = q.next;
                if (q == null) return head;
            }
            if (q == null) break;
        }

        return head;

    }

    public static void main(String[] args) {
        new NodeTools().PrintNodeList(new Solution().deleteDuplicates(new NodeTools().CreateNodeList("1->1->1->2->3->3")));
    }
}
