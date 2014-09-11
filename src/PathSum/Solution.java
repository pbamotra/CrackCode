package PathSum;

import Tools.TreeNode;
import Tools.TreeTools;

import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 3:05 PM
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {

        return !visit(root, 0, sum);

    }

    public boolean visit(TreeNode root, int t, int sum) {
        if (root == null) return true;
        if (t + root.val == sum && root.left == null && root.right == null) return false;
        return visit(root.left, t + root.val, sum) &&
                visit(root.right, t + root.val, sum);
    }

    public static void main(String[] args) {
        System.out.print(new Solution().hasPathSum(new TreeTools().getTree3(), 1));
    }
}
