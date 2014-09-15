package PopulatingNextRightPointersInEachNode;

import Tools.TreeLinkNode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 10:58 AM
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 * <p/>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode p = root;
        TreeLinkNode q = null;
        while (p.left != null) {
            q = p;
            while (q != null) {
                q.left.next = q.right;
                if (q.next != null) q.right.next = q.next.left;
                q = q.next;
            }
            p = p.left;
        }

    }

    public static void main(String[] args) {

    }

}
