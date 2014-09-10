package RemoveNthNodeFromEndOfList;

import Tools.ListNode;
import Tools.NodeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 3:22 PM
 * <p/>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p/>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (n > 0) {
            p = p.next;
            n--;
        }
        if (p == null) {
            head = head.next;
            return head;
        }
        ListNode q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return head;
    }

    public static void main(String[] args) {
        new NodeTools().PrintNodeList(new Solution().removeNthFromEnd(new NodeTools().CreateNodeList("1->2"), 2));
        new NodeTools().PrintNodeList(new NodeTools().CreateNodeList("1->2->3->4->5"));
    }

}
