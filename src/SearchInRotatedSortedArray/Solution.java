package SearchInRotatedSortedArray;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/8/14
 * Time: 2:55 PM
 */
public class Solution {
    public int search(int[] A, int target) {

        int l = 0;
        int h = A.length - 1;
        // find the min of the array.
        while (l < h) {
            int mid = (l + h) / 2;
            if (A[mid] > A[h]) l = mid + 1;
            else h = mid;
        }

        int lowest = l;
        l = 0;
        h = A.length;
        while (l < h) {
            int mid = (l + h) / 2;
            int trueMid = (mid + lowest) % A.length;
            if (A[trueMid] == target) return trueMid;
            else if (A[trueMid] < target) l = mid + 1;
            else h = mid;
        }
        return -1;

    }

    public static void main(String[] args){
        System.out.println(new Solution().search(new int[]{4,5,6,7,0,1,2},1));
    }
}
