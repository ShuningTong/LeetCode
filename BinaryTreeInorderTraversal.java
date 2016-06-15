import java.util.LinkedList;
public class BinaryTreeInorderTraversal {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        LinkedList<Integer> q = inorderTraversal(root);
        for (Integer i: q){
            System.out.println(i);
        }
    }

    public static LinkedList<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> q = new LinkedList<>();
        inorder(root, q);
        return q;
    }

    public static void inorder(TreeNode node, LinkedList<Integer> q){
        if (node == null){
            return;
        }
        inorder(node.left, q);
        q.add(node.val);
        inorder(node.right, q);
    }
}
