import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTreeRightSideView {
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
            LinkedList<Integer> view = rightSideView(root);
            for (Integer i: view){
                System.out.print(i + " ");
            }
        }else{
            System.out.println("Not valid input!");
        }
    }

    public static LinkedList<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> view = new LinkedList<>();
        if (root == null){
            return view;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode curNode = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            // this while loop is important, it controls the iteration of the outer while loop
            while (size > 0){
                curNode = queue.remove();
                if (size == 1){
                    view.add(curNode.val);
                }
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                } 
                size--;
            }   
        }
        return view;
    }
}
