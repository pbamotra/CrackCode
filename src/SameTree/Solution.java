package SameTree;

import Tools.TreeNode;
import Tools.TreeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 9:40 AM
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.left != null && q.left == null) return false;
        if (p.left == null && q.left != null) return false;
        if (p.right != null && q.right == null) return false;
        if (p.right == null && q.right != null) return false;
        if (p.val != q.val) return false;
        if (p.val == q.val && p.left == null && q.left == null && p.right == null && q.right == null) return true;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {

        System.out.print(new Solution().isSameTree(new TreeTools().getTree1(), new TreeTools().getTree1()));

    }
}