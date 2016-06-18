//https://leetcode.com/discuss/45386/4-lines-c-java-python-ruby

public class LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        // this one shows that although we change the root in the lowestCommonAncestor() method,
        // we didn't actually change root outside of method.
        System.out.println(lowestCommonAncestor(root, root.left, root.left.left).val);
        System.out.println(root.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return root;
        }
    }
}
