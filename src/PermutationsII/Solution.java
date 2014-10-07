package PermutationsII;

import Tools.ListTools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/7/14
 * Time: 12:11 AM
 */
public class Solution {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    boolean[] used;
    Set<String> mapping = new HashSet<String>();

    public List<List<Integer>> permuteUnique(int[] num) {
        used = new boolean[num.length];
        visit(new ArrayList<Integer>(), num);
        return results;

    }

    public void visit(List<Integer> result, int[] numbers) {
        if (result.size() == numbers.length) {
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
            if (!used[i]) {
                used[i] = true;
                result.add(numbers[i]);
                visit(result, numbers);
                used[i] = false;
                result.remove(result.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().permuteUnique(new int[]{3,3,0,0,2,3,2}));
    }
}
