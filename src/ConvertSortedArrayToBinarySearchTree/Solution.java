package ConvertSortedArrayToBinarySearchTree;

import Tools.TreeNode;
import Tools.TreeTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 4:35 PM
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        if (num.length == 1) return new TreeNode(num[0]);
        return convertToTree(0, num.length, num);
    }

    public TreeNode convertToTree(int start, int end, int[] num) {
        if (start >= end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = convertToTree(start, mid, num);
        root.right = convertToTree(mid + 1, end, num);

        return root;
    }

    public static void main(String[] args) {
        TreeTools.PrintTree(new Solution().sortedArrayToBST(new int[]{1, 2, 3, 4}));
        TreeTools.PrintTree(new Solution().sortedArrayToBST(new int[]{1, 3}));
    }


}
