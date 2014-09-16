package ValidParentheses;

import java.util.Stack;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/15/14
 * Time: 10:52 PM
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                if (t != '(') return false;
            } else if (c == '}') {
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                if (t != '{') return false;
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                if (t != '[') return false;
            } else {
                return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args){
        System.out.println(new Solution().isValid("(){}[]"));
        System.out.println(new Solution().isValid(")))[]"));
        System.out.println(new Solution().isValid("("));

    }
}
