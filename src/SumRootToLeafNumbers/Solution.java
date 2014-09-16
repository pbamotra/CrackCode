package SumRootToLeafNumbers;

import Tools.TreeNode;
import Tools.TreeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 9:56 PM
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return visit(root, 0, 0);
    }

    public int visit(TreeNode n, int sum, int total) {
        if (n == null) return 0;
        if (n.left == null && n.right == null) {
            total += sum * 10 + n.val;
            return total;
        }
        return visit(n.left, sum * 10 + n.val, total) + visit(n.right, sum * 10 + n.val, total);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sumNumbers(TreeTools.getTree1()));
    }


}
