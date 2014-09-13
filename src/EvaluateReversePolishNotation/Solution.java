package EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/13/14
 * Time: 10:58 AM
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                if (s.equals("+")) {
                    stack.push(String.valueOf(b + a));
                } else if (s.equals("-")) {
                    stack.push(String.valueOf(b - a));
                } else if (s.equals("*")) {
                    stack.push(String.valueOf(b * a));
                } else if (s.equals("/")) {
                    stack.push(String.valueOf(b / a));
                }
            } else {
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"}));

    }
}
