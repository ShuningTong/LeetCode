//https://leetcode.com/discuss/44959/3-lines-with-o-1-space-1-liners-alternatives

public class LowestCommonAncestorOfBinarySearchTree {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        // this one shows that although we change the root in the lowestCommonAncestor() method,
        // we didn't actually change root outside of method.
        System.out.println(lowestCommonAncestor(root, root.left, root.left.left).val);
        System.out.println(root.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0){
            if (p.val < root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return root;
    }
}
