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

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        while (true) {
            while (p.val < q.val && p.next.val < q.val) {
                p = p.next;
                if (p == null) break;
                if (p.next == null) break;
            }
            while (p.val < q.val && p.next.val >= q.val) {
                ListNode temp = q.next;
                q = p.next;
                p.next = q;
                q = temp;
            }
        }

        //return l1;
    }

    public static void main(String[] args) {
        new NodeTools().PrintNodeList(new Solution().mergeTwoLists(
                new NodeTools().CreateNodeList("1->2"),
                new NodeTools().CreateNodeList("")));
        new NodeTools().PrintNodeList(new Solution().mergeTwoLists(
                new NodeTools().CreateNodeList(""),
                new NodeTools().CreateNodeList("2->3")));
        new NodeTools().PrintNodeList(new Solution().mergeTwoLists(
                new NodeTools().CreateNodeList("2"),
                new NodeTools().CreateNodeList("2->3")));
        new NodeTools().PrintNodeList(new Solution().mergeTwoLists(
                new NodeTools().CreateNodeList("1->2"),
                new NodeTools().CreateNodeList("2")));
        new NodeTools().PrintNodeList(new Solution().mergeTwoLists(
                new NodeTools().CreateNodeList("1->2"),
                new NodeTools().CreateNodeList("3->4")));
        new NodeTools().PrintNodeList(new Solution().mergeTwoLists(
                new NodeTools().CreateNodeList("1->3"),
                new NodeTools().CreateNodeList("2->4")));

    }
}