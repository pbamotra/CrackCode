package AddTwoNumbers;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/18/13
 * Time: 5:44 PM
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ListNode list = null;
        ListNode tail = null;
        int carry = 0;

        while (true) {
            if ((l1 == null) && (l2 == null)) {
                if (carry == 1) {
                    ListNode node = new ListNode(1);
                    tail.next = node;
                    tail = node;
                    carry = 0;
                }
                break;
            } else if ((l1 != null) && (l2 != null)) {
                int value = l1.val + l2.val + carry;
                if (value >= 10) {
                    carry = 1;
                    value = value % 10;
                } else {
                    carry = 0;
                }
                ListNode node = new ListNode(value);
                if (list == null) {
                    list = node;
                    tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            } else if ((l1 != null) && (l2 == null)) {
                if (carry == 1) {
                    l2 = new ListNode(1);
                    carry = 0;
                    continue;
                } else {
                    tail.next = l1;
                    break;
                }
            } else if ((l1 == null) && (l2 != null)) {
                if (carry == 1) {
                    l1 = new ListNode(1);
                    carry = 0;
                    continue;
                } else {
                    tail.next = l2;
                    break;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return list;
    }
}
