package Tools;

/**
 * User: Ran Chen <ranc@cs.cmu.edu>
 * Date: 9/11/14
 * Time: 9:11 AM
 */
public class TreeTools {

    static public void PrintTree(TreeNode n) {
        visit(n);
        System.out.println();
    }

    static void visit(TreeNode n) {
        if (n == null) {
            System.out.print("# ");
            return;
        } else System.out.print(n.val + " ");
        if (n.left != null) visit(n.left);
        if (n.right != null) visit(n.right);
    }

    static public TreeNode getSymmetricTree() {
        TreeNode n = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        n.left = a;
        n.right = b;
        return n;
    }

    static public TreeNode getTree1() {
        //1
        //
        TreeNode n = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        n.left = a;
        n.right = b;
        a.left = c;

        return n;
    }

    static public TreeNode getTree2() {
        TreeNode n = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        n.left = a;
        n.right = b;
        a.right = c;

        return n;
    }

    static public TreeNode getTree3() {
        TreeNode n = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        n.left = a;

        return n;
    }

    static public TreeNode getTree4() {
        TreeNode n = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);

        n.left = a;
        a.left = b;
        return n;
    }
}
