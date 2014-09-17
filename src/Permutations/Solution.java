package Permutations;

import Tools.ListTools;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 8:48 PM
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        if (num.length == 0) return null;
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        dfs(result, list, num, new boolean[num.length], 0);
        return result;

    }

    public void dfs(List<List<Integer>> result, List<Integer> list, int[] num, boolean[] isVisit, int n) {
        if (n == num.length) {
            result.add((LinkedList) ((LinkedList)list).clone());
            return;
        }
        for (int i = 0; i < isVisit.length; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                list.add(Integer.valueOf(num[i]));
                dfs(result, list, num, isVisit, n + 1);
                list.remove(Integer.valueOf(num[i]));
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().permute(new int[]{1, 2, 3}));
        ListTools.Print(new Solution().permute(new int[]{1}));

    }


}
