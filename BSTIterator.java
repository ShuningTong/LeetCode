import java.util.LinkedList;

// LeetCode requires:
// next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
// this requirement make sense because otherwise LeetCode only needs a LinkedList.
// 如果不是这些要求的话，这道题根本就是inorder traversal, 返回一个LinkedList就可以了

// this implementation runs in O(1) time but uses O(N) memory

// a better solution is:
// https://leetcode.com/discuss/20101/ideal-solution-using-stack-java

public class BSTIterator {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }

    LinkedList<Integer> q;

    public BSTIterator(TreeNode root) {
        this.q = new LinkedList<Integer>();
        inorder(root, q);
    }

    private void inorder(TreeNode x, LinkedList<Integer> q){
        if (x == null){
            return;
        }
        inorder(x.left, q);
        q.add(x.val);
        inorder(x.right, q);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return q.removeFirst();
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
