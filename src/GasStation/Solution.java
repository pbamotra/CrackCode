package GasStation;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/25/14
 * Time: 1:13 PM
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        boolean saved = false;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (gas[i] - cost[i] > 0 && !saved) {
                index = i;
                saved = true;
            }
            if (sum < 0 && (gas[i] - cost[i] < 0)) {
                saved = false;
            }
        }

        if (sum >= 0) return index;
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{4}, new int[]{5}));  //-1
        System.out.println(new Solution().canCompleteCircuit(new int[]{5}, new int[]{4}));      //0

    }


}
