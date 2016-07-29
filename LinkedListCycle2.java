/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// this post describes cycle related problems very well:
//http://www.cnblogs.com/hiddenfox/p/3408931.html
public class LinkedListCycle2 {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 9; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        System.out.println(detectCycle(head));
    }

    // the reason why here we return slow.val not slow is that:
    // we defined a toString method in ListNode.java
    // it can never print a list with cycle
    // OutOfMemoryError
    public static int detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(true){
            if (fast == null || fast.next == null){
                return 0;
            }

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
