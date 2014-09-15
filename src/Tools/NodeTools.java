package Tools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 4:46 PM
 */
public class NodeTools {
    static public ListNode CreateNodeList(String s) {
        //s = "1->2->3->4->5"
        if (s.length() == 0) return null;
        if (s.length() == 1) return new ListNode(Integer.valueOf(s));
        String[] numbers = s.split("->");
        ListNode listNode = new ListNode(Integer.valueOf(numbers[0]));
        ListNode last = listNode;
        for (int i = 1; i < numbers.length; i++) {
            ListNode l = new ListNode(Integer.valueOf(numbers[i]));
            last.next = l;
            last = l;
        }
        return listNode;
    }

    static public void PrintNodeList(ListNode listNode) {
        ListNode p = listNode;
        if (p == null) return;
        while (p.next != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println(p.val);
    }
}
