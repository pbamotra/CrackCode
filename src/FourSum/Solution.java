package FourSum;

import Tools.ListTools;

import java.util.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/15/14
 * Time: 12:05 AM
 */
public class Solution {

    Set<List<Integer>> results = new HashSet<List<Integer>>();

    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        int length = num.length;

        int k = length - 1;
        for (int a = 0; a < length; a++) {
            for (int b = a + 1; b < length; b++) {
                for (int c = b + 1; c < length; c++) {
                    if (k == c && k < length - 1) k++;
                    int sum0 = num[a] + num[b] + num[c];
                    int sum = sum0 + num[k];
                    if (sum == target && k > c) {
                        results.add(Arrays.asList(num[a], num[b], num[c], num[k]));
                        k--;
                    } else if (sum < target) {
                        while (sum < target && k < length - 1) {
                            k++;
                            sum = sum0 + num[k];
                        }
                        if (sum == target) results.add(Arrays.asList(num[a], num[b], num[c], num[k]));
                    } else if (sum > target) {
                        while (sum > target && k > c + 1) {
                            k--;
                            sum = sum0 + num[k];
                        }
                        if (sum == target) results.add(Arrays.asList(num[a], num[b], num[c], num[k]));

                    }
                }
            }
        }
        return getResult();
    }

    public List<List<Integer>> getResult() {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        resultList.addAll(results);
        return resultList;
    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
