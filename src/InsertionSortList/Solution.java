package InsertionSortList;

import Tools.ListNode;
import Tools.ListTools;
import Tools.NodeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/16/14
 * Time: 5:15 PM
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;

        ListNode p = head;
        ListNode q = head;
        ListNode i = head.next;
        while (i != null) {
            if (i.val >= q.val) {
                q = q.next;
                i = i.next;
            } else if (i.val <= p.val) {
                ListNode t = i.next;
                i.next = p;
                p = i;
                q.next = t;
                i = t;
            } else {
                ListNode t = p;
                if (t == q) break;
                while (t != q && t.val < i.val && t.next.val < i.val) {
                    t = t.next;
                }
                ListNode k = i.next;
                i.next = t.next;
                t.next = i;
                i = k;
                q.next = k;
            }
        }

        return p;

    }

    public static void main(String[] args) {
        NodeTools.PrintNodeList(new Solution().insertionSortList(NodeTools.CreateNodeList("1")));
        NodeTools.PrintNodeList(new Solution().insertionSortList(NodeTools.CreateNodeList("2->1")));
        NodeTools.PrintNodeList(new Solution().insertionSortList(NodeTools.CreateNodeList("3->2->1")));


    }
}