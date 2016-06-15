
import java.util.LinkedList;
public class BinaryTreePreorderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        LinkedList<Integer> q = preorderTraversal(root);
        for (Integer i: q){
            System.out.println(i);
        }
    }

    public static LinkedList<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> q = new LinkedList<>();
        preorder(root, q);
        return q;
    }

    public static void preorder(TreeNode node, LinkedList<Integer> q){
        if (node == null){
            return;
        }
        q.add(node.val);
        preorder(node.left, q);
        preorder(node.right, q);
    }
}
