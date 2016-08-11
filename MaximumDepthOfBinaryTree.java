/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Implementation: BFS travesal
 */
import java.util.LinkedList;
import java.util.Scanner;
public class MaximumDepthOfBinaryTree {
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
            System.out.println(maxDepth(root));
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

    // iterative method
    // 用BFS的方法一层一层往下搜索，直到找到最后一个节点就退出
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int mDepth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root.left != null){
            queue.add(root.left);
        }
        if (root.right != null){
            queue.add(root.right);
        }
        TreeNode curNode = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            // this while loop is important, it controls the iteration of the outer while loop
            while (size > 0){
                curNode = queue.remove();
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                } 
                size--;
            }
            mDepth++;       
        }
        return mDepth;
    }

    // 分治
    // Maximum depth = Math.max(leftchild.depth, rightchild.depth) + 1
    //递归三要素之一：定义
    //把root.depth找到
    public static int maxDepthDC(TreeNode cur) {
        //递归三要素之二：极端小的状态
        if (cur == null){
            return 0;
        }
        //递归三要素之三：如何变为更小的状态
        return Math.max(maxDepth(cur.left), maxDepth(cur.right)) + 1;
    }
}
