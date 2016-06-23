import java.util.LinkedList;
import java.util.Scanner;
//https://leetcode.com/discuss/17615/java-solution-recursive-%26-non-recursive
public class FlattenBinaryTreeToLinkedList {
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
            flatten(root);
            LinkedList<Integer> q = BinaryTreePreorderTraversal.preorderTraversal(root);
            for (Integer i: q){
                System.out.println(i);
            }
        }else{
            System.out.println("Not valid input!");
        }
    }

    public static void flatten(TreeNode root) {
        TreeNode node = root;
        while(node != null){
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null){
                TreeNode temp = left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = right;
                node.right = left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
