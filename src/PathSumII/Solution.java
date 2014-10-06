package PathSumII;

import Tools.Interval;
import Tools.ListTools;
import Tools.TreeNode;
import Tools.TreeTools;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 10:35 AM
 */
public class Solution {
    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return results;
        visit(root, 0, sum, new ArrayList<Integer>());
        return results;
    }

    public void visit(TreeNode node, int sum, int total, List<Integer> result) {
        result.add(node.val);
        if (node.val + sum == total && node.left == null && node.right == null) {
            results.add(new ArrayList<Integer>(result));
            return;
        }
        if (node.left != null) {
            visit(node.left, sum + node.val, total, result);
            result.remove(result.size() - 1);
        }
        if (node.right != null) {
            visit(node.right, sum + node.val, total, result);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().pathSum(TreeTools.getTree3(), 1));
        ListTools.Print(new Solution().pathSum(TreeTools.getSymmetricTree(), 3));
    }


}
