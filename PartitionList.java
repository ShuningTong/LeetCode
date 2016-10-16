/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode part2Head = new ListNode(0);
        ListNode part2Ptr = part2Head;
        
        ListNode prev = dummyNode;
        ListNode curt = head;
        while(curt != null){
            if (curt.val >= x){
                prev.next = curt.next;
                curt.next = null;
                part2Ptr.next = curt;
                part2Ptr = part2Ptr.next;
                curt = prev.next;
            } else {
                prev = curt;
                curt = prev.next;
            }
        }
        prev.next = part2Head.next;
        return dummyNode.next;
    }
}
