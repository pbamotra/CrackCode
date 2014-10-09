package SearchInRotatedSortedArrayII;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/8/14
 * Time: 2:55 PM
 */
public class Solution {
    public boolean search(int[] A, int target) {
        int l = 0;
        int h = A.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (A[m] == target) return true;
            if (A[l] < A[m]) {//l--m is sorted
                if (A[l] <= target && target < A[m]) { // target is in l--m
                    h = m - 1;
                } else {
                    l = m + 1;
                }

            } else if (A[l] > A[m]) { //m--h is sorted
                if (A[m] < target && target <= A[h]) {//target is in m--h
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            } else {
                l++;
            }
        }

        return false;

    }

    public int binarySearch(int[] A, int target, int start, int end) {
        if (end <= start) return -1;
        int mid = (start + end) / 2;
        if (A[mid] == target) return mid;
        else if (A[mid] < target) return binarySearch(A, target, mid + 1, end);
        else return binarySearch(A, target, start, mid);

    }

    public int binarySearch2(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] < target) start = mid + 1;
            else end = mid;
        }
        return -1;
    }

    public int binarySearchMain(int[] A, int target) {
        return binarySearch2(A, target);
        //return binarySearch(A, target, 0, A.length);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().binarySearchMain(new int[]{1, 2, 3}, 1));
        System.out.println(new Solution().binarySearchMain(new int[]{1, 2, 3}, 2));
        System.out.println(new Solution().binarySearchMain(new int[]{1, 2, 3}, 3));
        System.out.println(new Solution().binarySearchMain(new int[]{1, 2, 3}, 4));

    }
}
