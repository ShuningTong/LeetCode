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
public class LinkedListCycle {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 9; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
