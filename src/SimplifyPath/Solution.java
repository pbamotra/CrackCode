package SimplifyPath;

import java.util.*;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 10/27/14
 * Time: 9:33 PM
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String name : names) {
            if (name.equals(".") || name.equals("") || name.equals("..") && stack.isEmpty()) {
                continue;
            } else if (name.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(name);
            }
        }

        List<String> result = new ArrayList<String>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        StringBuffer sb = new StringBuffer();
        for (int i = result.size() - 1; i >= 0; i--) {
            String s = result.get(i);
            sb.append("/" + s);
        }
        if (sb.length() == 0) sb.append("/");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/../"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
        System.out.println(new Solution().simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));


    }

}
