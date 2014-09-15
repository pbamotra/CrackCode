package MergeSortedArray;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 5:44 PM
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k] = A[i];
                k--;
                i--;
            } else {
                A[k] = B[j];
                k--;
                j--;
            }
        }
        while (j >= 0) {
            A[k] = B[j];
            k--;
            j--;
        }

    }
    public static void main(String[] args){
        new Solution().merge(new int[]{1,4,6,0,0},3,new int[]{2,5},2);
    }
}
