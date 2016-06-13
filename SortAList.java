public class SortAList {

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
        // head == null is only in case that the original list is null
        if(head == null || head.next == null){
            return head;
        }
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while(fastPointer != null){
            fastPointer = fastPointer.next;
            if(fastPointer == null){
                break;
            }
            fastPointer = fastPointer.next;
            if(fastPointer == null){
                break;
            }
            slowPointer = slowPointer.next;
        }
        ListNode secondHead = slowPointer.next;
        slowPointer.next = null;

        ListNode l1 = sort(head);
        ListNode l2 = sort(secondHead);
        return mergeTwoListsInPlace(l1, l2);

    }

    public static ListNode sortBU(ListNode head) {
        

    }

    public static ListNode mergeTwoListsInPlace(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode small, big, prevSmall = null;
        small = l1.val <= l2.val ? l1 : l2;
        big = l1.val <= l2.val ? l2 : l1;
        ListNode result = small;
        while (big != null) {
            while (small != null && small.val <= big.val) {
                prevSmall = small;
                small = small.next;
            }
            prevSmall.next = big;
            big = small;
            small = prevSmall.next;
        }
        return result;
    }
}
