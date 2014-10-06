package SwapNodesInPairs;

import Tools.ListNode;
import Tools.ListTools;
import Tools.NodeTools;
import org.w3c.dom.NodeList;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/18/13
 * Time: 8:17 PM
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        for (ListNode n = start; n.next != null && n.next.next != null; n = n.next.next) {
            n.next = swap(n.next, n.next.next);
        }

        return start.next;
    }

    public ListNode swap(ListNode a, ListNode b) {
        a.next = b.next;
        b.next = a;
        return b;
    }

    public static void main(String[] args) {
        NodeTools.PrintNodeList(new Solution().swapPairs(NodeTools.CreateNodeList("1->2->3->4")));
    }
}
