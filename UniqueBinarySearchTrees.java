import java.util.LinkedList;
// Dynamic Programming Question
public class UniqueBinarySearchTrees {

    public static void main(String[] args){
        if (args != null && args.length != 0){
            int n = Integer.parseInt(args[0]);
            System.out.println(numTrees(n));
        }else{
            System.out.println("Not valid input!");
        }
    }

    // this is the DP solution for calculating the number of unique BST trees
    public static int numTrees(int n) {
        assert n >= 0;

        int[] results = new int[n + 1];
        results[0] = 1;
        if (n >= 1){
            results[1] = 1;
            if (n >= 2){
                results[2] = 2;
                for (int i = 3; i <= n; i++){
                    results[i] = 0;
                    for (int j = 1; j <= i; j++){
                        results[i] += results[j - 1] * results[i - j];
                    }
                } 
            }  
        }

        return results[n];
    }

    // this is the DP solution for generating unique BST trees
    public static LinkedList<TreeNode> generateTrees(int n){
        // this is for when n== 0, return [] instead of [[]]
        if (n == 0){
            return new LinkedList<TreeNode>();
        }
        assert n > 0;
        @SuppressWarnings("unchecked") 
        LinkedList<TreeNode>[] result = new LinkedList[n + 1];
        result[0] = new LinkedList<TreeNode>();
        result[0].add(null);

        for (int i = 1; i <= n; i++){
            result[i] = new LinkedList<TreeNode>();
            for (int j = 1; j <= i; j++){
                for(TreeNode leftNode: result[j - 1]){
                    for (TreeNode rightNode: result[i - j]){
                        TreeNode root = new TreeNode(j);
                        root.left = leftNode;
                        root.right = offset(rightNode, j);
                        result[i].add(root);
                    }
                }
            }
        }
        return result[n];
    }

    // offset each node using a preorder traversal
    private static TreeNode offset(TreeNode n, int offset){
        if (n == null){
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = offset(n.left, offset);
        node.right = offset(n.right, offset);
        return node;
    }
}
