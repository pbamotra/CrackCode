package BinaryTreePostorderTraversal;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<Integer>();
        visit(root, l);
        return l;
    }

    public void visit(TreeNode root, List<Integer> l) {
        if (root == null) return;
        visit(root.left, l);
        visit(root.right, l);
        l.add(root.val);
    }

    public static void main(String[] args) {
        new ListTools().PrintList(new Solution().postorderTraversal(new TreeTools().getTree2()));
    }
}
