import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class BinaryTreeInorderTraversal {

    // 用递归的方法非常简单
    List<Integer> results;

    public List<Integer> inorderTraversal(TreeNode root) {
        results = new ArrayList<Integer>();
        helper(root);
        return results;
    }

    public void helper(TreeNode cur){
        if (cur == null){
            return;
        }
        helper(cur.left);
        results.add(cur.val);
        helper(cur.right);
    }

    // 用非递归也可以，需要用到stack，这个思路要学会
    // 先一层一层到达左边最底部，把沿路经过的node全部放进stack里面，
    // 当到达底部之后，开始从stack中pop node出来，将该node.val加入results
    // 然后将cur指针放在node.right，如果有right，那么会继续一层层到达左边最底部
    // 如果没有right，那么又会从stack中pop出下一个node
    
    // https://discuss.leetcode.com/topic/1285/has-anyone-solved-this-without-using-a-hashmap-for-already-visited-nodes/3
    public List<Integer> inorderTraversalIterative(TreeNode cur){
        results = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.empty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                results.add(cur.val);
                cur = cur.right;
            }
        }
        return results;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        BinaryTreeInorderTraversal inorder = new BinaryTreeInorderTraversal();
        List<Integer> q = inorder.inorderTraversalIterative(root);
        for (Integer i: q){
            System.out.println(i);
        }
    }
}
