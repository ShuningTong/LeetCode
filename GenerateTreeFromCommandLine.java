import java.util.LinkedList;
import java.util.Scanner;
public class GenerateTreeFromCommandLine{
    public static TreeNode generateTree(int rootVal){
        TreeNode root = new TreeNode(rootVal);
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
        return root;
    }
}
