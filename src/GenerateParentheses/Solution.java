package GenerateParentheses;

import Tools.ListTools;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 6:19 PM
 * <p/>
 * For example, given n = 3, a solution set is:
 * <p/>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {
    List<String> result = new ArrayList<String>();
    String parenthesis = "()";

    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(), n, n);
        return result;
    }

    public void generate(StringBuilder sb, int left, int right) {
        if (right < left || left < 0) return;
        else if (right == 0 && left == 0) result.add(sb.toString());
        else {
            for (int i = 0; i < 2; i++) {
                sb.append(parenthesis.charAt(i));
                if (i == 0) generate(sb, left-1, right);
                else generate(sb, left, right-1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        ListTools.PrintStringList(new Solution().generateParenthesis(4));
    }


}
