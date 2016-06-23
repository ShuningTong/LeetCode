// one thinking is to traverse the tree using inorder and test whether it is sorted
// here, we use recursive method
public class ValidateBinarySearchTree {
    public static void main(String[] args){
        if (args != null && args.length != 0){
            int rootVal = Integer.parseInt(args[0]);
            TreeNode root = GenerateTreeFromCommandLine.generateTree(rootVal);
            System.out.println(isValidBST(root));
        }else{
            System.out.println("Not valid input!");
        }

    }

    public static boolean isValidBST(TreeNode root) {
        return recursive(root);
    }

    public static boolean recursive(TreeNode node){
        if (node == null){
            return true;
        }
        if (node.left == null && node.right == null){
            return true;
        }else if (node.left != null && node.right != null){
            int rightMostLeft = rightMost(node.left);
            int leftMostRight = leftMost(node.right);
            if (!(rightMostLeft < node.val && leftMostRight > node.val)){
                return false;
            }
        }else{
            if (node.left != null){
                int rightMostLeft = rightMost(node.left);
                if (rightMostLeft >= node.val){
                    return false;
                }
            }else{
                int leftMostRight = leftMost(node.right);
                if (leftMostRight <= node.val){
                    return false;
                }
            }
        }
        boolean left = true;
        boolean right = true;
        if (node.left != null){
            left = recursive(node.left); 
        }
        if (node.right != null){
            right = recursive(node.right);
        }
        if (left && right){
            return true;
        }else{
            return false;
        }

    }

    // assume node != null
    public static int rightMost(TreeNode node){
        if (node.right == null){
            return node.val;
        }else{
            return rightMost(node.right);
        }
    }

    // assume node != null
    public static int leftMost(TreeNode node){
        if (node.left == null){
            return node.val;
        }else{
            return leftMost(node.left);
        }
    }

}
