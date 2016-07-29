public class PalindromeLinkedList{
    // requires O(n) time and O(1) space
    // there is an interesting discussion I bookmarked for space complexity
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 9; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println(head);
        System.out.println(isPalindrome(head));
        System.out.println(head);
    }

    public static boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // odd numbers of listNodes, slow will be the node after the mid point
        if (fast != null){
            slow = slow.next;
        }

        // notice: because we reverse one part of the list, the original list (head) is also modified.
        // 1-2-3-3-2-1
        // reverse the second half: 3-2-1
        // it becomes 1-2-3
        // the original list becomes 1-2-3-3 (the last 3 is the same one with the last 3 of the previous line)
        // if we want to keep the original list intact, we should do reverse again.
        slow = ReverseLinkedList.reverseListIterative(slow);
        
        ListNode cur = head;
        while(slow != null && cur.val == slow.val){
            cur = cur.next;
            slow = slow.next;
        }
        return slow == null;
    }
}
