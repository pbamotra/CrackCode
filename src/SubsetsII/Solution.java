package SubsetsII;

import Tools.ListTools;

import java.util.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 1:08 AM
 */
public class Solution {
    Set<String> strings = new HashSet<String>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        used = new boolean[num.length];
        Arrays.sort(num);
        for (int k = 0; k <= num.length; k++) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            visit(result, new ArrayList<Integer>(), num, k);
            results.addAll(result);
        }
        return results;


    }

    public void visit(List<List<Integer>> results, List<Integer> result, int[] n, int k) {
        if (result.size() == k) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : result) sb.append(i);
            String s = sb.toString();
            if (strings.contains(s)) {
                return;
            } else {
                results.add(new ArrayList<Integer>(result));
                strings.add(s);
            }
        } else {
            for (int i = 0; i < n.length; i++) {
                if (used[i] || result.size() != 0 && n[i] < result.get(result.size() - 1)) {
                    continue;
                }
                result.add(n[i]);
                used[i] = true;
                visit(results, result, n, k);
                result.remove(result.size() - 1);
                used[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        //  ListTools.Print(new Solution().subsetsWithDup(new int[]{1, 4, 3, 5, 4, 4, 7, 7, 8, 0}));
        ListTools.Print(new Solution().subsetsWithDup(new int[]{0}));

    }
}
