package BinaryTreeLevelOrderTraversal;

import Tools.ListTools;
import Tools.TreeNode;
import Tools.TreeTools;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 9:25 PM
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result ;
        List<Integer> list = new LinkedList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int i = 0;
        int j = 1;
        queue.add(root);
        while (i <= j && i < queue.size()) {
            list = new LinkedList<Integer>();
            int count = 0;
            for (int k = i; k < j; k++) {
                TreeNode n = queue.get(k);
                list.add(n.val);
                if (n.left != null) {
                    count++;
                    queue.add(n.left);
                }
                if (n.right != null) {
                    count++;
                    queue.add(n.right);
                }
            }
            result.add(list);
            i = j;
            j = j + count;
        }


        return result;
    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().levelOrder(TreeTools.getTree1()));
    }
}
