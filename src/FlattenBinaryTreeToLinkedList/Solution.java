package FlattenBinaryTreeToLinkedList;

import Tools.TreeNode;
import Tools.TreeTools;

import java.util.Stack;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/8/14
 * Time: 3:22 PM
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode tail = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            if (tail != null) {
                tail.left = null;
                tail.right = node;
            }
            tail = node;
        }

        return;

    }

    public static void main(String[] args) {
        TreeNode n = TreeTools.getSymmetricTree();
        new Solution().flatten(n);
        TreeTools.PrintTree(n);
    }
}
