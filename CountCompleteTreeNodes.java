//https://leetcode.com/discuss/38930/concise-java-solutions-o-log-n-2
public class CountCompleteTreeNodes {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        int h = height(root);
        if (h == 0){
            return 0;
        }else{
            // the last node is on the right subtree, left subtree is full of height (h - 1)
            // the left subtree has 2^(h - 1) - 1 nodes, plus 1 for the root
            if (height(root.right) == h - 1){
                return (1 << h-1) + countNodes(root.right);
            // the last node is on the left subtree, right subtree is full of height (h - 2)
            // the right subtree has 2^(h - 2) - 1 nodes, plus 1 for the root
            }else{
                return (1 << h-2) + countNodes(root.left);
            }
        }

    }

    // this method can be used as helper method in many tree related classes
    public static int height(TreeNode root){
        if (root == null){
            return 0;
        }else{
            return 1 + height(root.left);
        }
    }
}
