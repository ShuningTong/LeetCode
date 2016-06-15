public class ConvertSortedListToBST {

    public static void main(String[] args){
        ConvertSortedListToBST newConvert = new ConvertSortedListToBST();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        TreeNode node = newConvert.sortedListToBST(head);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.left.left.val);
        System.out.println(node.right.val);
        System.out.println(node.right.left.val);

    }

    ListNode curListNode;

    public int count(ListNode node){
        int size = 0;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }

    public TreeNode sortedListToBST(ListNode head){
        curListNode = head;
        return generate(count(head));
    }

    public TreeNode generate(int size){
        if (size == 0){
            return null;
        }
        TreeNode newTreeNode = new TreeNode(0);
        newTreeNode.left = generate(size / 2);
        newTreeNode.val = curListNode.val;
        curListNode = curListNode.next;
        newTreeNode.right = generate(size - 1 - size / 2); 
        return newTreeNode;
    }
}
