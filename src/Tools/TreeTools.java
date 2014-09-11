package Tools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 9:11 AM
 */
public class TreeTools {
    public TreeNode getTree1() {
        TreeNode n = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        n.left = a;
        n.right = b;
        a.left = c;

        return n;
    }

    public TreeNode getTree2() {
        TreeNode n = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        n.left = a;
        n.right = b;
        a.right = c;

        return n;
    }
}
