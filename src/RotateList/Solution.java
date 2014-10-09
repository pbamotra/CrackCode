package RotateList;

import Tools.ListNode;
import Tools.NodeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/9/14
 * Time: 5:29 PM
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null) return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        n = n % length;
        if (n == 0) return head;
        n = length - n;
        ListNode p = head;
        ListNode pBore = head;
        while (n > 1) {
            pBore = pBore.next;
            n--;
        }
        p = pBore.next;
        pBore.next = null;
        ListNode start = p;
        tail.next = head;

        return start;

    }

    public static void main(String[] args) {
        NodeTools.PrintNodeList(new Solution().rotateRight(NodeTools.CreateNodeList("1->2->3->4->5"), 2));
        NodeTools.PrintNodeList(new Solution().rotateRight(NodeTools.CreateNodeList("1->2"), 1));
        NodeTools.PrintNodeList(new Solution().rotateRight(NodeTools.CreateNodeList("1->2"), 0));


    }
}
