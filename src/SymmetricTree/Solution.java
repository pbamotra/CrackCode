package SymmetricTree;

import Tools.TreeNode;
import Tools.TreeTools;

import java.util.Stack;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 5:19 PM
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root.left);
        s2.push(root.right);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null ^ n2 == null) return false;
            if (n1.val != n2.val) return false;
            if (s1.isEmpty() ^ s2.isEmpty()) return false;
            s1.push(n1.left);
            s1.push(n1.right);
            s2.push(n2.right);
            s2.push(n2.left);

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSymmetric(TreeTools.getSymmetricTree()));
        System.out.println(new Solution().isSymmetric(TreeTools.getTree1()));
    }
}
