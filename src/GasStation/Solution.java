package GasStation;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/25/14
 * Time: 1:13 PM
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int start = 0;
        int next = 1;
        int amount = 0;
        for (int i = 0; i < 2 * length; i++) {
            int j = i % length;
            next = (i + 1) % length;
            if (amount + gas[j] - cost[j] >= 0) {
                amount = amount + gas[j];
            }

        }
        return 0;
    }

    public static void main(String[] args) {
    }


}
