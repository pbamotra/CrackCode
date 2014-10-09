package RemoveDuplicatesFromSortedListII;

import Tools.ListNode;
import Tools.ListTools;
import Tools.NodeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/12/14
 * Time: 2:46 PM
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = head;
        ListNode pBefore = start;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                while (p.next != null && p.val == p.next.val) {
                    p.next = p.next.next;
                }
                pBefore.next = p.next;
                p = p.next;
            } else {
                p = p.next;
                pBefore = pBefore.next;
            }
        }
        return start.next;
    }

    public static void main(String[] args) {
        new NodeTools().PrintNodeList(new Solution().deleteDuplicates(new NodeTools().CreateNodeList("1->1->1->2->3")));
        new NodeTools().PrintNodeList(new Solution().deleteDuplicates(new NodeTools().CreateNodeList("1->2->3->3->4->4->5")));
        new NodeTools().PrintNodeList(new Solution().deleteDuplicates(new NodeTools().CreateNodeList("1->2->5->5")));
        new NodeTools().PrintNodeList(new Solution().deleteDuplicates(new NodeTools().CreateNodeList("1->1->2->2")));
        new NodeTools().PrintNodeList(new Solution().deleteDuplicates(new NodeTools().CreateNodeList("1->1->1")));



    }
}
