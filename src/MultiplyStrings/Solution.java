package MultiplyStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 8:17 PM
 */
public class Solution {
    public String multiply(String num1, String num2) {
        List<Integer> result = new ArrayList<Integer>();
        if (num1.equals("0") || num2.equals("0")) return "0";
        String sLarge;
        String sSmall;
        if (num1.length() > num2.length()) {
            sLarge = num1;
            sSmall = num2;
        } else {
            sLarge = num2;
            sSmall = num1;
        }

        for (int i = sSmall.length() - 1; i >= 0; i--) {
            add(result, times(sLarge, sSmall.charAt(i), sSmall.length() - 1 - i));
        }

        return transferResult(result);
    }

    public List<Integer> times(String a, char b, int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            result.add(0);
        }
        for (int i = a.length() - 1; i >= 0; i--) {
            result.add((a.charAt(i) - '0') * (b - '0'));
        }
        return result;
    }

    public void add(List<Integer> a, List<Integer> b) {
        int la = a.size();
        int lb = b.size();
        if (la > lb) {
            for (int i = 0; i < lb; i++) {
                a.set(i, a.get(i) + b.get(i));
            }
        } else if (la <= lb) {
            for (int i = 0; i < la; i++) {
                a.set(i, a.get(i) + b.get(i));
            }
            for (int i = la; i < lb; i++) {
                a.add(b.get(i));
            }
        }
    }

    public String transferResult(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size() - 1; i++) {
            int n = result.get(i);
            if (n >= 10) {
                int one = n / 10;
                n = n % 10;
                result.set(i, n);
                result.set(i + 1, result.get(i + 1) + one);
            }
        }
        while (result.get(result.size() - 1) >= 10) {
            int n = result.get(result.size() - 1);
            int one = n / 10;
            n = n % 10;
            result.set(result.size() - 1, n);
            result.add(one);
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "21"));
    }
}
