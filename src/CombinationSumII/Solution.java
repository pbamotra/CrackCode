package CombinationSumII;

import Tools.ListTools;

import java.util.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 11:12 AM
 */
public class Solution {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    boolean[] used;
    Set<String> mapping = new HashSet<String>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        visit(new ArrayList<Integer>(), candidates, 0, target, 0);
        return results;
    }

    public void visit(List<Integer> result, int[] numbers, int sum, int total, int n) {
        result.add(n);
        if (n + sum > total) {
            return;
        } else if (n + sum == total) {
            if (result.contains(0)) result.remove(0);
            StringBuilder sb = new StringBuilder();
            for (Integer i : result) {
                sb.append(i);
            }
            String s = sb.toString();
            if (!mapping.contains(s)) {
                results.add(new ArrayList<Integer>(result));
                mapping.add(s);
            }

            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < n || used[i]) continue;
            used[i] = true;
            visit(result, numbers, sum + n, total, numbers[i]);
            result.remove(result.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
