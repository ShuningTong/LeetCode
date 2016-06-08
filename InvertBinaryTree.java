/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// future improvement: print the binary tree so that we can see the effect of inverse.
import java.util.LinkedList;
import java.util.Scanner;
public class InvertBinaryTree {
    public static void main(String[] args){
        if (args != null && args.length != 0){
            int curVal = Integer.parseInt(args[0]);
            TreeNode root = new TreeNode(curVal);
            Scanner sc = new Scanner(System.in);
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode curNode = null;
            while(!queue.isEmpty()){
                curNode = queue.remove();
                String childS = "";
                int childVal = 0;

                System.out.println(curNode.val + "\'s left:(k for skip, e for end)");
                childS = sc.next();
                if (childS.equalsIgnoreCase("e")){
                    break;
                }
                if (!childS.equalsIgnoreCase("k")){
                    childVal = Integer.parseInt(childS);
                    curNode.left = new TreeNode(childVal);
                    queue.add(curNode.left);
                }
                

                System.out.println(curNode.val + "\'s right:");
                childS = sc.next();
                if (childS.equalsIgnoreCase("e")){
                    break;
                }
                if (!childS.equalsIgnoreCase("k")){
                    childVal = Integer.parseInt(childS);
                    curNode.right = new TreeNode(childVal);
                    queue.add(curNode.right);
                }  
            }
            invertTree(root);
        }else{
            System.out.println("Not valid input!");
        }
    }

    public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }

    // use a BFS trevasal
    // invert each pair of children for every node
    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null){
            return root;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode newRoot = root;
        queue.add(newRoot);
        TreeNode curNode = null;

        while (!queue.isEmpty()){
            int size = queue.size();
            // this while loop is important, it controls the iteration of the outer while loop
            while (size > 0){
                curNode = queue.remove();
                
                TreeNode tempNode = curNode.left;
                curNode.left = curNode.right;
                curNode.right = tempNode;

                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                } 
                size--;
            }       
        }
        return newRoot;
    }
}
