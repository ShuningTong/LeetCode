import java.util.LinkedList;
public class SameTree {

    public static void main(String[] args){
        if (args != null && args.length != 0){
            int rootValx = Integer.parseInt(args[0]);
            TreeNode rootx = GenerateTreeFromCommandLine.generateTree(rootValx);
            int rootValy = Integer.parseInt(args[1]);
            TreeNode rooty = GenerateTreeFromCommandLine.generateTree(rootValy);
            System.out.println(isSameTreeAdvanced(rootx, rooty));
        }else{
            System.out.println("Not valid input!");
        }
    }

    // preorder traversal
    public static boolean isSameTreeOriginal(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }else if(p != null && q != null){
            if (p.val != q.val){
                return false;
            }
        }else{
            return false;
        }
        return isSameTreeOriginal(p.left, q.left) && isSameTreeOriginal(p.right, q.right);
    }

    public static boolean isSameTreeAdvanced(TreeNode p, TreeNode q){
        return (p == null && q == null) || (p != null && q != null && p.val == q.val && isSameTreeAdvanced(p.left, q.left) && isSameTreeAdvanced(p.right, q.right));
    }

    public static boolean isSameTreeBFS(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }else if (p == null || q == null){
            return false;
        }
        LinkedList<TreeNode> queuex = new LinkedList<>();
        LinkedList<TreeNode> queuey = new LinkedList<>();

        queuex.add(p);
        queuey.add(q);

        TreeNode curNodex = null;
        TreeNode curNodey = null;

        while (!queuex.isEmpty() && !queuey.isEmpty()){
            int sizex = queuex.size();
            int sizey = queuey.size();
            if (sizex != sizey){
                return false;
            }
            // this while loop is important, it controls the iteration of the outer while loop
            while (sizex > 0){
                curNodex = queuex.remove();
                curNodey = queuey.remove();
                if (curNodex.val != curNodey.val){
                    return false;
                }
                if (curNodex.left != null && curNodey.left != null){
                    queuex.add(curNodex.left);
                    queuey.add(curNodey.left);
                }else if(curNodex.left == null && curNodey.left == null){
                }else{
                    return false;
                }

                if (curNodex.right != null && curNodey.right != null){
                    queuex.add(curNodex.right);
                    queuey.add(curNodey.right);
                }else if(curNodex.right == null && curNodey.right == null){
                }else{
                    return false;
                }
                 
                sizex--;
                sizey--;
            }   
        }
        if (!queuex.isEmpty() || !queuey.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
