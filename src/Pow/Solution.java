package Pow;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 12/15/13
 * Time: 12:58 AM
 */
public class Solution {
    public double pow(double x, int n) {
        if (x == 1.0) {
            return 1.0;
        }
        if (x == 0.0) {
            return 0.0;
        }
        if (x == -1.0) {
            if (n % 2 == 0) {
                return 1.0;
            } else if (n % 2 == 1) {
                return -1.0;
            }
        }

        double a = 1.0;
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }

        for (int i = 0; i < n; i++) {
            a = a * x;
            if ((a == 0.0) || (a == 1.0)) break;
        }

        if (isNegative) {
            a = 1 / a;
        }

        return a;
    }

    static public void main(String[] args) {
        System.out.println(new Solution().pow(0.1, -2));
    }
}
