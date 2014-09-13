package ReverseNodesInKGroup;

import Tools.ListNode;
import Tools.NodeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/12/14
 * Time: 3:38 PM
 * <p/>
 * Given this linked list: 1->2->3->4->5
 * <p/>
 * For k = 2, you should return: 2->1->4->3->5
 * <p/>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        while (head.next != null) {
            head.next = q;
            q = q.next;
            p = p.next;
            q.next = p;
            p = q;

        }
        return head;
    }

    public static void main(String[] args) {
        new NodeTools().PrintNodeList(new Solution().reverseKGroup(new NodeTools().CreateNodeList("1->2->3->4->5"), 2));
        new NodeTools().PrintNodeList(new Solution().reverseKGroup(new NodeTools().CreateNodeList("1->2->3->4->5"), 3));


        new NodeTools().PrintNodeList(new Solution().reverseList(new NodeTools().CreateNodeList("1->2->3->4->5")));

    }

}
