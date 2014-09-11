package MaximumDepthOfBinaryTree;

import Tools.TreeNode;
import Tools.TreeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 9:07 AM
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }


    public static void main(String[] args) {
        System.out.print(new Solution().maxDepth(new TreeTools().getTree1()));
    }
}
