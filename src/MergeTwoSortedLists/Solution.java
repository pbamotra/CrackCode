package MergeTwoSortedLists;

import Tools.ListNode;
import Tools.ListTools;
import Tools.NodeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 11:06 AM
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = l1;

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (q.val < p.val) {
            head = q;
            while (q.next != null && q.next.val <= p.val) {
                q = q.next;
            }
            ListNode t = q.next;
            q.next = p;
            q = t;
        }


        while (p != null && q != null) {
            if (p.next == null) {
                p.next = q;
                return head;
            } else if (p.val <= q.val && p.next.val <= q.val) {
                p = p.next;
            } else if (p.val <= q.val && p.next.val > q.val) {
                ListNode t = q.next;
                q.next = p.next;
                p.next = q;
                q = t;
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        NodeTools.PrintNodeList(new Solution().mergeTwoLists(
                NodeTools.CreateNodeList("2->5"),
                NodeTools.CreateNodeList("1->2")));
        NodeTools.PrintNodeList(new Solution().mergeTwoLists(
                NodeTools.CreateNodeList("1->2->5"),
                NodeTools.CreateNodeList("2->3")));
        NodeTools.PrintNodeList(new Solution().mergeTwoLists(
                NodeTools.CreateNodeList("1->2"),
                NodeTools.CreateNodeList("")));
        NodeTools.PrintNodeList(new Solution().mergeTwoLists(
                NodeTools.CreateNodeList(""),
                NodeTools.CreateNodeList("2->3")));
        NodeTools.PrintNodeList(new Solution().mergeTwoLists(
                NodeTools.CreateNodeList("2"),
                NodeTools.CreateNodeList("2->3")));
        NodeTools.PrintNodeList(new Solution().mergeTwoLists(
                NodeTools.CreateNodeList("1->2"),
                NodeTools.CreateNodeList("2")));
        NodeTools.PrintNodeList(new Solution().mergeTwoLists(
                NodeTools.CreateNodeList("1->2"),
                NodeTools.CreateNodeList("3->4")));
        NodeTools.PrintNodeList(new Solution().mergeTwoLists(
                NodeTools.CreateNodeList("1->3"),
                NodeTools.CreateNodeList("2->4")));

    }
}