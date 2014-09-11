package UniqueBinarySearchTrees;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 3:53 PM
 */
public class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += numTrees(i) * numTrees(n - i - 1);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}
