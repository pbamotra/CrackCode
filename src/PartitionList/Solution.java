package PartitionList;

import Tools.ListNode;
import Tools.ListTools;
import Tools.NodeTools;
import org.w3c.dom.NodeList;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/8/14
 * Time: 5:21 PM
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode tail = start;// add to tail.next
        ListNode p = head;
        ListNode pBefore = start;
        while (p != null) {
            if (p.val < x) {
                if (pBefore == tail) {
                    p = p.next;
                    pBefore = pBefore.next;
                    tail = tail.next;
                    continue;
                }
                pBefore.next = p.next;
                p.next = tail.next;
                tail.next = p;
                p = pBefore.next;
                tail = tail.next;
            } else {
                p = p.next;
                pBefore = pBefore.next;
            }
        }
        return start.next;

    }

    public static void main(String[] args) {
        NodeTools.PrintNodeList(
                new Solution().partition(
                        NodeTools.CreateNodeList("1->4->3->2->5->2"), 3));
        NodeTools.PrintNodeList(
                new Solution().partition(
                        NodeTools.CreateNodeList("1->1"), 2));
    }
}
