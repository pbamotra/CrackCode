package Sqrt;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/28/14
 * Time: 12:46 AM
 */
public class Solution {
    public int sqrt(int x) {
        if (x == 0 || x == 1) return x;
        int start = 1;
        int end = x;
        int result=0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == x / mid) return mid;
            else if (mid > x / mid) end = mid - 1;
            else {
                start = mid + 1;
                result = mid;
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(new Solution().sqrt(99));
    }
}
