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
        if (root == null) return true;
        if (Math.abs(visit(root.left) - visit(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.left);

    }

    public int visit(TreeNode root) {
        if (root == null) return 0;
        return Math.max(visit(root.left), visit(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isBalanced(new TreeTools().getTree4()));
    }
}