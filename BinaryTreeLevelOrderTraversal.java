import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTreeLevelOrderTraversal {
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
            LinkedList<LinkedList<Integer>> listCollection = levelOrderZigzag(root);
            for (LinkedList<Integer> list: listCollection){
                for (Integer i: list){
                    System.out.print(i + " ");
                }
                System.out.println("");
            }
        }else{
            System.out.println("Not valid input!");
        }
    }

    public static LinkedList<LinkedList<Integer>> levelOrder(TreeNode root) {
        LinkedList<LinkedList<Integer>> listCollection = new LinkedList<>();
        if (root == null){
            return listCollection;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode curNode = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            // this while loop is important, it controls the iteration of the outer while loop
            LinkedList<Integer> curList = new LinkedList<Integer>();
            while (size > 0){
                curNode = queue.remove();
                curList.add(curNode.val);
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                } 
                size--;
            }
            listCollection.add(curList);     
        }
        return listCollection;
    }

    // this is a special level order traversal, it's bottom-up
    // e.g. 
        // 3
      //  / \
      // 9  20
      //   /  \
      //  15   7
    // will return
//   [[15,7],
//   [9,20],
//   [3]]
    // the implementation is very simple, just add each list to the start of listCollection
    public static LinkedList<LinkedList<Integer>> levelOrderBU(TreeNode root) {
        LinkedList<LinkedList<Integer>> listCollection = new LinkedList<>();
        if (root == null){
            return listCollection;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode curNode = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            // this while loop is important, it controls the iteration of the outer while loop
            LinkedList<Integer> curList = new LinkedList<Integer>();
            while (size > 0){
                curNode = queue.remove();
                curList.add(curNode.val);
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                } 
                size--;
            }
            listCollection.addFirst(curList);     
        }
        return listCollection;
    }

    public static LinkedList<LinkedList<Integer>> levelOrderZigzag(TreeNode root) {
        LinkedList<LinkedList<Integer>> listCollection = new LinkedList<>();
        if (root == null){
            return listCollection;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode curNode = null;
        boolean reverse = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            // this while loop is important, it controls the iteration of the outer while loop
            LinkedList<Integer> curList = new LinkedList<Integer>();

            while (size > 0){
                curNode = queue.remove();
                if (reverse){
                    curList.addFirst(curNode.val);
                }else{
                    curList.add(curNode.val);
                }
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                } 
                size--;
            }
            reverse = !reverse;
            listCollection.add(curList);     
        }
        return listCollection;
    }
}
