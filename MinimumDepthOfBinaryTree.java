import java.util.LinkedList;
import java.util.Scanner;

/* The minimum depth is the number of nodes (inclusive) along the shortest path 
from the root node down to the nearest leaf node.

根节点不是一个叶子节点
如果只有根节点自己，那么最小深度为1
如果是  
  1
 / \ 
2   3
   / \
  4   5
最小深度为2

*/

public class MinimumDepthOfBinaryTree {
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
            System.out.println(minDepth(root));
        }else{
            System.out.println("Not valid input!");
        }
    }

    // iterative method
    // 用BFS的方法一层一层往下搜索，直到找到一个叶子节点就退出
    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int mDepth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curNode = null;

        outerloop:
        while (!queue.isEmpty()){
            int size = queue.size();
            // this while loop is important, it controls the iteration of the outer while loop
            while (size > 0){
                curNode = queue.remove();
                if (curNode.left == null && curNode.right == null){
                    break outerloop;
                }else if (curNode.left != null && curNode.right != null){
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                }else{
                    if (curNode.left != null){
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null){
                        queue.add(curNode.right);
                    } 
                }
                size--;
            }
            mDepth++;       
        }
        return mDepth;
    }

    // 分治
    // 分成两个方法是因为根节点为null和其他节点为null的处理情况不一样
    // Minimum depth = Math.min(leftchild.depth, rightchild.depth) + 1
    // null子的最小深度为非法值，因为我们想要的是从根节点到叶子节点的距离
    // null不是一个叶子节点
    public static int minDepthDC(TreeNode root) {
        if (root == null){
            return 0;
        }
        return getMin(root);
    }

    public static int getMin(TreeNode cur){
        if (cur == null){
            return Integer.MAX_VALUE;
        }
        if (cur.left == null && cur.right == null){
            return 1;
        }
        int left = getMin(cur.left);
        int right = getMin(cur.right);
        return Math.min(left, right) + 1;
    }
}
