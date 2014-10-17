package FourSum;

import Tools.ListTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/15/14
 * Time: 12:05 AM
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        int length = num.length;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int a = 0; a < length; a++) {
            for (int b = a + 1; b < length; b++) {
                for (int c = b + 1; c < length; c++) {
                    for (int d = c + 1; d < length; d++) {
                        if (num[a] + num[b] + num[c] + num[d] == target) {
                            results.add(new ArrayList<Integer>(Arrays.asList(num[a], num[b], num[c], num[d])));

                        }
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        ListTools.Print(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
