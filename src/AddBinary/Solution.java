package AddBinary;

import java.util.ArrayList;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 9:45 PM
 */
public class Solution {
    public String addBinary(String a, String b) {
        String small;
        String large;
        if (a.length() > b.length()) {
            small = b;
            large = a;
        } else {
            small = a;
            large = b;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = small.length() - 1; i >= 0; i--) {
            int j = large.length() - small.length() + i;
            result.add((small.charAt(i) - '0') + (large.charAt(j) - '0'));
        }
        for (int i = large.length() - small.length() - 1; i >= 0; i--) {
            result.add((large.charAt(i) - '0'));
        }
        for (int i = 0; i < result.size() - 1; i++) {
            int n = result.get(i);
            if (n >= 2) {
                int one = n / 2;
                n = n % 2;
                result.set(i, n);
                result.set(i + 1, result.get(i + 1) + one);
            }
        }
        while (result.get(result.size() - 1) >= 2) {
            int n = result.get(result.size() - 1);
            int one = n / 2;
            n = n % 2;
            result.set(result.size() - 1, n);
            result.add(one);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }
}
