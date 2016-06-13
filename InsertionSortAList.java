public class InsertionSortAList {

    public static void main(String[] args){
        ListNode l1 = new ListNode(10);
        ListNode l1Cur = l1;
        for (int i = 9; i > 0; i--){
            l1Cur.next = new ListNode(i);
            l1Cur = l1Cur.next;
        }
        // this is the unsorted list
        System.out.println(l1);
        // this is the sorted list
        System.out.println(sort(l1));
        // this is what is left at head after sorting
        System.out.println(l1);
    }
    public static ListNode sort(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode cur = head;
        ListNode next;
        
        ListNode sortedListHead = new ListNode(0);
        ListNode insertPoint;
        
        while(cur != null){
            next = cur.next;
            insertPoint = sortedListHead;

            while(insertPoint.next != null && insertPoint.next.val <= cur.val){
                insertPoint = insertPoint.next;
            }
            cur.next = insertPoint.next;
            insertPoint.next = cur;
            cur = next;
        }
        return sortedListHead.next;
    }
}
