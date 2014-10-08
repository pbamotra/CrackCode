package MinimumDepthOfBinaryTree;

import Tools.TreeNode;
import Tools.TreeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/7/14
 * Time: 8:55 PM
 */
public class Solution {
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        visit(root, 0);
        return minDepth + 1;
    }

    public void visit(TreeNode n, int level) {
        if (n.left == null && n.right == null) {
            if (level < minDepth) minDepth = level;
            return;
        }
        if (n.left != null) visit(n.left, level + 1);
        if (n.right != null) visit(n.right, level + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDepth(TreeTools.getTree1()));
        System.out.println(new Solution().minDepth(new TreeNode(0)));

    }
}
