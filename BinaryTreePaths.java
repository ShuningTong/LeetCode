import java.util.LinkedList;
import java.util.Scanner;
//https://leetcode.com/discuss/52072/accepted-java-simple-solution-in-8-lines

public class BinaryTreePaths {
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
            LinkedList<String> paths = binaryTreePaths(root);
            for (String path: paths){
                System.out.println(path);
            }

        }else{
            System.out.println("Not valid input!");
        }
    }

    public static LinkedList<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        if (root == null){
            return paths;
        }
        recursive(root, "", paths);
        return paths;
    }

    public static void recursive(TreeNode cur, String path, LinkedList<String> paths){
        if (cur.left == null && cur.right == null){
            paths.add(path + cur.val);
        }
        if (cur.left != null){
            recursive(cur.left, path + cur.val + " -> ", paths);
        }
        if (cur.right != null){
            recursive(cur.right, path + cur.val + " -> ", paths);
        }
    }
}
