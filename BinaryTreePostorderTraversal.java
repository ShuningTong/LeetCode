import java.util.LinkedList;

public class BinaryTreePostorderTraversal {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        LinkedList<Integer> q = postorderTraversal(root);
        for (Integer i: q){
            System.out.println(i);
        }
    }
    public static LinkedList<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> q = new LinkedList<>();
        postorder(root, q);
        return q;
    }

    public static void postorder(TreeNode node, LinkedList<Integer> q){
        if (node == null){
            return;
        }
        postorder(node.left, q);
        postorder(node.right, q);
        q.add(node.val);
    }
}
