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

        slow = ReverseLinkedList.reverseListIterative(slow);
        
        ListNode cur = head;
        while(slow != null && cur.val == slow.val){
            cur = cur.next;
            slow = slow.next;
        }
        return slow == null;
    }
}
