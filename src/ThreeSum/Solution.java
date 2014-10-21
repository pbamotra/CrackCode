package ThreeSum;

import Tools.ListTools;

import java.util.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/17/14
 * Time: 3:37 PM
 */
public class Solution {
    Set<List<Integer>> results = new HashSet<List<Integer>>();

    public List<List<Integer>> threeSum(int[] num) {
        int length = num.length;
        Arrays.sort(num);

        int k = length - 1;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum0 = num[i] + num[j];
                if (sum0 > 0) return getResult();
                int sum = sum0 + num[k];
                if (sum == 0) results.add(Arrays.asList(num[i], num[j], num[k]));
                else if (sum < 0) {

                } else if (sum > 0) {

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
        ListTools.Print(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
