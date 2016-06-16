import java.util.LinkedList;
import java.util.Scanner;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // this main method is to build a tree from input first, and then output its inorder and preorder traversal based on previous written classes, and then call buildTree() method, and then output the new tree's post order traversal to prove everything is correct.
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
            LinkedList<Integer> preq = BinaryTreePreorderTraversal.preorderTraversal(root);
            LinkedList<Integer> inq = BinaryTreeInorderTraversal.inorderTraversal(root);

            int[] preorder = new int[preq.size()];
            for (int i = 0; i < preorder.length; i++){
                preorder[i] = preq.get(i);
                System.out.print(preorder[i] + " ");
            }

            System.out.println("");

            int[] inorder = new int[inq.size()];
            for (int i = 0; i < inorder.length; i++){
                inorder[i] = inq.get(i);
                System.out.print(inorder[i] + " ");
            }

            System.out.println("");

            TreeNode newRoot = buildTree(preorder, inorder);
            LinkedList<Integer> postq = BinaryTreePostorderTraversal.postorderTraversal(newRoot);
            for (Integer i: postq){
                System.out.print(i + " ");
            }

        }else{
            System.out.println("Not valid input!");
        }
    }

    // this method comes from the discussion board:
    // https://leetcode.com/discuss/18101/sharing-my-straightforward-recursive-solution
    // I have the same thinking before I read this post.
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return create(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode create(int[] preorder, int[] inorder, int ps, int pe, int is, int ie){
        if (ps > pe){
            return null;
        }
        TreeNode curNode = new TreeNode(preorder[ps]);
        int pos = 0;
        for (int i = is; i <= ie; i++){
            if (inorder[i] == curNode.val){
                pos = i;
                break;
            }
        }
        curNode.left = create(preorder, inorder, ps + 1, ps + pos - is, is, pos - 1);
        curNode.right = create(preorder, inorder, ps + pos - is + 1, pe, pos + 1, ie);
        return curNode;
    }
}
