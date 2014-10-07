package CountAndSay;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/6/14
 * Time: 11:54 PM
 */
public class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < s.length()) {
                char a = s.charAt(j);
                int count = 1;
                while (j < s.length() - 1 && s.charAt(j + 1) == a) {
                    j++;
                    count++;
                }
                sb.append(count);
                sb.append(a);
                j++;
            }
            s = sb.toString();
        }


        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(2));
    }


}
