package LongestConsecutiveSequence;

import java.util.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/24/14
 * Time: 7:58 PM
 */
public class Solution {
    public int longestConsecutive(int[] num) {
        if (num.length == 0) return 0;
        if (num.length == 1) return 1;
        Set<Integer> set = new HashSet<Integer>();

        for (Integer n : num) {
            set.add(n);
        }

        int max = 0;

        for (Integer n : num) {
            int length = 1;
            int a = n + 1;
            while (set.contains(a)) {
                length++;
                set.remove(a);
                a++;
            }
            int b = n - 1;
            while (set.contains(b)) {
                length++;
                set.remove(b);
                b--;
            }
            if (length > max)
                max = length;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
