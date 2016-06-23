import java.util.LinkedList;
public class SymmetricTree{
    public static void main(String[] args){
        // System.out.println(Integer.MIN_VALUE == Integer.MIN_VALUE);
        // LinkedList<Integer> test = new LinkedList<>();
        // test.add(0);
        // test.clear();
        // System.out.println(test.size());
        if (args != null && args.length != 0){
            int rootVal = Integer.parseInt(args[0]);
            TreeNode root = GenerateTreeFromCommandLine.generateTree(rootVal);
            System.out.println(isSymmetricRecursive(root));
        }else{
            System.out.println("Not valid input!");
        }
    }

    // a problem here is that Integer.MIN_VALUE is an object.
    // so in LinkedList<Integer>, there are ints, there are Integers.
    // put ints into LinkedList<Integer> is fine, but they always have the same reference (== will return true).
    // so if we want to compare by value, not by reference, we should use Integer.equals() method
    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        queue.add(root);
        TreeNode curNode = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                curNode = queue.remove();
                if (curNode != null){
                    level.add(curNode.val);
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                }else{
                    level.add(Integer.MIN_VALUE);
                }
                size--;
            }
            for (int i = 0, j = level.size() - 1; i <= j; i++, j--){
                if (!level.get(i).equals(level.get(j))){
                    return false;
                }
            }
            level.clear();
        }
        return true;
    }


    public static boolean isSymmetricRecursive(TreeNode root) {
        return recursive(root, root);
    }

    // preorder traversal, one start from left, one start from right
    public static boolean recursive(TreeNode rootx, TreeNode rooty){
        if (rootx == null && rooty == null){
            return true;
        }else if (rootx != null && rooty != null){
            if (rootx.val != rooty.val){
                return false;
            }
        }else{
            return false;
        }

        return recursive(rootx.left, rooty.right) && recursive(rootx.right, rooty.left);
    }
}
