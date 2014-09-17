package BinaryTreeInorderTraversal;

import Tools.ListTools;
import Tools.TreeNode;
import Tools.TreeTools;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 9:56 AM
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<Integer>();
        visit(root, l);
        return l;
    }

    public void visit(TreeNode root, List<Integer> l) {
        if (root == null) return;
        visit(root.left, l);
        l.add(root.val);
        visit(root.right, l);
    }

    public static void main(String[] args) {
        new ListTools().PrintIntegerList(new Solution().inorderTraversal(new TreeTools().getTree2()));
    }
}
