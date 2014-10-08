package SearchInRotatedSortedArrayII;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/8/14
 * Time: 2:55 PM
 */
public class Solution {
    public int search(int[] A, int target) {
        return 1;
    }

    public int binarySearch(int[] A, int target, int start, int end) {
        if (end <= start) return -1;
        int mid = (start + end) / 2;
        if (A[mid] == target) return mid;
        else if (A[mid] < target) return binarySearch(A, target, mid + 1, end);
        else return binarySearch(A, target, start, mid);

    }

    public int binarySearchMain(int[] A, int target) {
        return binarySearch(A, target, 0, A.length);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().binarySearchMain(new int[]{1, 2, 3}, 1));
        System.out.println(new Solution().binarySearchMain(new int[]{1, 2, 3}, 2));
        System.out.println(new Solution().binarySearchMain(new int[]{1, 2, 3}, 3));
        System.out.println(new Solution().binarySearchMain(new int[]{1, 2, 3}, 4));

    }
}
