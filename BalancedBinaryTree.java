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

    public static int dfsHeight(TreeNode cur){
        if (cur == null){
            return 0;
        }
        int left = dfsHeight(cur.left);
        int right = dfsHeight(cur.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
