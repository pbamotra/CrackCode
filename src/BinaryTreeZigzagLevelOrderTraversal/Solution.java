package BinaryTreeZigzagLevelOrderTraversal;

import Tools.ListTools;
import Tools.TreeNode;
import Tools.TreeTools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/27/14
 * Time: 9:57 PM
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) return results;
        if (root.left == null && root.right == null) {
            List<Integer> r = new ArrayList<Integer>();
            r.add(root.val);
            results.add(r);
            return results;
        }

        int level = 1;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> tempList = new LinkedList<TreeNode>();
            tempList.addAll((LinkedList<TreeNode>) queue.clone());
            queue = new LinkedList<TreeNode>();
            for (TreeNode t : tempList) {
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            List<Integer> l = new ArrayList<Integer>();
            if (level % 2 == 1) {
                for (int i = 0; i < tempList.size(); i++) {
                    l.add(tempList.get(i).val);
                }
            } else {
                for (int i = tempList.size() - 1; i >= 0; i--) {
                    l.add(tempList.get(i).val);
                }
            }
            results.add(l);
            level++;

        }
        return results;

    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().zigzagLevelOrder(TreeTools.getTree1()));
    }

}
