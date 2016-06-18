import java.util.LinkedList;
import java.util.Scanner;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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
            LinkedList<Integer> postq = BinaryTreePostorderTraversal.postorderTraversal(root);
            LinkedList<Integer> inq = BinaryTreeInorderTraversal.inorderTraversal(root);

            int[] postorder = new int[postq.size()];
            for (int i = 0; i < postorder.length; i++){
                postorder[i] = postq.get(i);
                System.out.print(postorder[i] + " ");
            }

            System.out.println("");

            int[] inorder = new int[inq.size()];
            for (int i = 0; i < inorder.length; i++){
                inorder[i] = inq.get(i);
                System.out.print(inorder[i] + " ");
            }

            System.out.println("");

            TreeNode newRoot = buildTree(inorder, postorder);
            LinkedList<Integer> preq = BinaryTreePreorderTraversal.preorderTraversal(newRoot);
            for (Integer i: preq){
                System.out.print(i + " ");
            }

        }else{
            System.out.println("Not valid input!");
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return create(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode create(int[] inorder, int[] postorder, int is, int ie, int ps, int pe){
        if (ps > pe){
            return null;
        }
        TreeNode curNode = new TreeNode(postorder[pe]);
        int pos = 0;
        for (int i = is; i <= ie; i++){
            if (inorder[i] == curNode.val){
                pos = i;
                break;
            }
        }
        curNode.left = create(inorder, postorder, is, pos - 1, ps, ps + pos - is - 1);
        curNode.right = create(inorder, postorder, pos + 1, ie, ps + pos - is, pe - 1);
        return curNode;
    }
}
