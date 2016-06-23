//https://leetcode.com/discuss/22898/the-bottom-up-o-n-solution-would-be-better

public class BalancedBinaryTree {

    public static void main(String[] args){
        if (args != null && args.length != 0){
            int rootVal = Integer.parseInt(args[0]);
            TreeNode root = GenerateTreeFromCommandLine.generateTree(rootVal);
            System.out.println(isBalanced(root));
        }else{
            System.out.println("Not valid input!");
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public static int dfsHeight(TreeNode curNode){
        if (curNode == null){
            return 0;
        }
        int leftHeight = dfsHeight(curNode.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = dfsHeight(curNode.right);
        if (rightHeight == -1){
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
