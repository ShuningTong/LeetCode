public class ConvertSortedArrayToBST {

    public static void main(String[] args){
        ConvertSortedArrayToBST newConvert = new ConvertSortedArrayToBST();
        int[] a = new int[5];
        for (int i = 0; i < 5; i++){
            a[i] = i;
        }

        TreeNode node = newConvert.sortedArrayToBST(a);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.left.left.val);
        System.out.println(node.right.val);
        System.out.println(node.right.left.val);

    }

    int curIndex;

    public TreeNode sortedArrayToBST(int[] a) {
        curIndex = 0;
        return generate(a.length, a);
    }

    public TreeNode generate(int size, int[] a){
        if (size == 0){
            return null;
        }
        TreeNode newTreeNode = new TreeNode(0);
        newTreeNode.left = generate(size / 2, a);
        newTreeNode.val = a[curIndex];
        curIndex++;
        newTreeNode.right = generate(size - 1 - size / 2, a); 
        return newTreeNode;
    }
}
