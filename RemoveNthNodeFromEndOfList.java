/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode ptr = head;
        for (int i = 2; i < 9; i++){
            ptr.next = new ListNode(i);
            ptr = ptr.next;
        }
        System.out.println(removeNthFromEndOfList(head, 8));
    }

    public static ListNode removeNthFromEndOfList(ListNode head, int n) {
        ListNode start, end;
        start = head;
        end = head;
        for (int i = 0; i < n; i++){
            end = end.next;
        }

        if (end == null){
            head = head.next;
            return head;
        }else{
            while(end.next != null){
                start = start.next;
                end = end.next;
            }
            start.next = start.next.next;
            return head;
        }
    }
}
