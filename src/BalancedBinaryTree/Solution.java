package BalancedBinaryTree;

import Tools.TreeNode;
import Tools.TreeTools;

import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 4:16 PM
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return visit(root, 0, 0);

    }

    public boolean visit(TreeNode root, int max, int n) {
        if (root == null) return true;
        if (n > max) max = n;
        if ((root.left == null || root.right == null) && Math.abs(max - n) > 1) return false;
        return visit(root.left, max, n + 1) &&
                visit(root.right, max, n + 1);
    }

    public static void main(String[] args) {
       System.out.println(new Solution().isBalanced(new TreeTools().getTree4()));
    }
}