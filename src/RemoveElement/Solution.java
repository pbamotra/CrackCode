package RemoveElement;

import Tools.ListTools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/10/14
 * Time: 9:37 PM
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == elem) {
                count++;
            } else {
                A[i - count] = A[i];
            }
        }
        return A.length - count;

    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1,3, 1};
        System.out.println(new Solution().removeElement(A, 1));
        new ListTools().PrintList(A);
    }
}
