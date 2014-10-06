package CombinationSum;

import Tools.ListTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 10:54 AM
 */
public class Solution {
    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        visit(new ArrayList<Integer>(), candidates, 0, target, 0);
        return results;
    }

    public void visit(List<Integer> result, int[] numbers, int sum, int total, int n) {
        result.add(n);
        if (n + sum > total) {
            return;
        } else if (n + sum == total) {
            if (result.contains(0)) result.remove(0);
            results.add(new ArrayList<Integer>(result));
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < n) continue;
            visit(result, numbers, sum + n, total, numbers[i]);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
