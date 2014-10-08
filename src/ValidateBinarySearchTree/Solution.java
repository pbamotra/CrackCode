package ValidateBinarySearchTree;

import Tools.TreeNode;
import Tools.TreeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/25/14
 * Time: 2:59 PM
 */
public class Solution {
    boolean result = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        visit(root);
        return result;
    }

    public int[] visit(TreeNode n) {
        if (n.left == null && n.right == null) {
            return new int[]{n.val, n.val};
        }

        int lMin = Integer.MAX_VALUE;
        int lMax = Integer.MIN_VALUE;
        int rMin = Integer.MAX_VALUE;
        int rMax = Integer.MIN_VALUE;

        if (n.left != null) {
            int[] l = visit(n.left);
            lMin = l[0];
            lMax = l[1];
        }
        if (n.right != null) {
            int[] r = visit(n.right);
            rMin = r[0];
            rMax = r[1];
        }
        if (rMin <= n.val || lMax >= n.val) result = false;

        int newMin = Math.min(Math.min(n.val, lMin), rMin);
        int newMax = Math.max(Math.max(n.val, lMax), rMax);

        return new int[]{newMin, newMax};
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isValidBST(TreeTools.getTree3()));
    }
}
