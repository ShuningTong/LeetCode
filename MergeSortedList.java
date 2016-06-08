/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeSortedList {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(10);
        ListNode l2 = new ListNode(2);
        ListNode l2Cur = l2;
        for (int i = 3; i < 10; i++){
            l2Cur.next = new ListNode(i);
            l2Cur = l2Cur.next;
        }
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(mergeTwoListsInPlace(l1, l2));

    }

    // this is the solution I implemented myself using a Not-In-Place algorithm.
    public static ListNode mergeTwoListsNotInPlace(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode l3Start;
        if (l2.val < l1.val){
            l3Start = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            l3Start = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode l3Cur = l3Start;
        while(!(l1 == null && l2 == null)){
            if (l1 == null){
                l3Cur.next = new ListNode(l2.val);
                l3Cur = l3Cur.next;
                l2 = l2.next;
            } else if (l2 == null){
                l3Cur.next = new ListNode(l1.val);
                l3Cur = l3Cur.next;
                l1 = l1.next;
            } else if (l2.val < l1.val){
                l3Cur.next = new ListNode(l2.val);
                l3Cur = l3Cur.next;
                l2 = l2.next;
            } else {
                l3Cur.next = new ListNode(l1.val);
                l3Cur = l3Cur.next;
                l1 = l1.next;
            }
        }
        return l3Start;
    }
    // this one is downloaded from Lexi's blog
    // https://leetcodenotes.wordpress.com/2013/08/01/merge-two-sorted-lists/
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
    // this function is never used because JAVA always pass parameter by value
    // so it does NOT work if we separate the swap function 
    public static void swap(ListNode small, ListNode big){
        ListNode temp = small;
        small = big;
        big = temp;
    }
}
