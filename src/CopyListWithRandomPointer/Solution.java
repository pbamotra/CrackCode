package CopyListWithRandomPointer;

import Tools.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/28/14
 * Time: 12:20 AM
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> ordToNew = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode headNode = new RandomListNode(head.label);
        if (head.random == null) {
            headNode.random = null;
        } else {
            RandomListNode newNode = new RandomListNode(head.random.label);
            ordToNew.put(head.random, newNode);
            headNode.random = newNode;
        }
        RandomListNode tailNode = headNode;
        RandomListNode p = head.next;
        while (p != null) {
            RandomListNode n = new RandomListNode(p.label);
            if (p.random == null) {
                n.random = null;
            } else if (ordToNew.containsKey(p.random)) {
                RandomListNode newNode = ordToNew.get(p.random);
                n.random = newNode;
            } else {
                RandomListNode newNode = new RandomListNode(p.random.label);
                ordToNew.put(p.random, newNode);
                n.random = newNode;
            }
            tailNode.next = n;
            tailNode = n;
            p = p.next;
        }

        return headNode;
    }
}
