/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList2 {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 9; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println(reverseBetween(head, 1, 5));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode beforeHead = new ListNode(0);
        beforeHead.next = head;
        ListNode start = beforeHead;
        ListNode reversePart = null;
        ListNode reversePartEnd = null;
        for (int i = 0; i < m - 1; i++){
            start = start.next;
        }
        reversePartEnd = start.next;
        for (int j = m; j <= n; j++){
            ListNode theReverseOne = start.next;
            start.next = start.next.next;
            theReverseOne.next = reversePart;
            reversePart = theReverseOne;
        }
        reversePartEnd.next = start.next;
        start.next = reversePart;
        return beforeHead.next;
    }
}
