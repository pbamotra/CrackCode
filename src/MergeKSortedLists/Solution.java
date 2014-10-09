package MergeKSortedLists;

import Tools.ListNode;

import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/9/14
 * Time: 5:52 PM
 */
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        if (lists.size() == 1) return lists.get(0);
        return merge(0, lists.size() - 1, lists);
    }

    public ListNode merge(int start, int end, List<ListNode> lists) {
        if (end - start == 1) {
            return mergeTwoLists(lists.get(start), lists.get(end));
        } else if (end == start) {
            return lists.get(start);
        }
        int mid = (start + end) / 2;
        ListNode l1 = merge(start, mid, lists);
        ListNode l2 = merge(mid + 1, end, lists);
        return mergeTwoLists(l1, l2);
    }

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
}
