package ValidateBinarySearchTree;

import Tools.TreeNode;
import Tools.TreeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/25/14
 * Time: 2:59 PM
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
         return visit(root);
    }

    public boolean visit(TreeNode n) {
        if (n == null) return true;
        if (n.left != null && n.left.val >= n.val) return false;
        if (n.right != null && n.right.val <= n.val) return false;


        return visit(n.left) & visit(n.right);
    }

    public static void main(String[] args) {
       System.out.println(new Solution().visit(TreeTools.getTree3()));
    }
}
