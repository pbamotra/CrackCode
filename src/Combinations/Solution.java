package Combinations;

import Tools.ListTools;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 12:34 AM
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        visit(results, new ArrayList<Integer>(), n, k);
        return results;


    }

    public void visit(List<List<Integer>> results, List<Integer> result, int n, int k) {
        if (result.size() == k) {
            results.add(new ArrayList<Integer>(result));
        } else {
            for (int i = 1; i <= n; i++) {
                if (result.size() != 0 && i <= result.get(result.size() - 1)) {
                    continue;
                }
                result.add(i);
                visit(results, result, n, k);
                result.remove(result.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().combine(4, 3));
    }
}
