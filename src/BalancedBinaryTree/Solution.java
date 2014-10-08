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
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        visit(root);
        return isBalanced;

    }

    public int visit(TreeNode root) {
        if (root == null) return 0;
        int l = visit(root.left);
        int r = visit(root.right);
        if (Math.abs(l - r) > 1) isBalanced = false;
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isBalanced(new TreeTools().getTree4()));
        System.out.println(new Solution().isBalanced(new TreeTools().getSymmetricTree()));

    }
}