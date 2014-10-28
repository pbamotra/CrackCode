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
                if (k == j && k < length - 1) k++;
                int sum0 = num[i] + num[j];
                int sum = sum0 + num[k];
                if (sum == 0 && k > j) {
                    results.add(Arrays.asList(num[i], num[j], num[k]));
                    k--;
                } else if (sum < 0) {
                    while (sum < 0 && k < length - 1) {
                        k++;
                        sum = sum0 + num[k];
                    }
                    if (sum == 0) results.add(Arrays.asList(num[i], num[j], num[k]));
                } else if (sum > 0) {
                    while (sum > 0 && k > j + 1) {
                        k--;
                        sum = sum0 + num[k];
                    }
                    if (sum == 0) results.add(Arrays.asList(num[i], num[j], num[k]));
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
        //ListTools.Print(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        ListTools.Print(new Solution().threeSum(new int[]{3, 0, -2, -1, 1, 2}));  //[[-2,-1,3],[-2,0,2],[-1,0,1]]

    }
}
