/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* assume 1 <= m <= n <= length of list*/
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

    /*
    1.处理Corner case
    2. find the m th node
    3. find the n th node
    4. break
    5. reverse
    6. connect
    
    因为这里只用了一个ptr：head，所以要格外小心什么时候把三段断掉
    */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;

        for (int i = 0; i < m - 1; i++){
            head = head.next;
        }
        ListNode firstEnd = head;
        ListNode secondStart = head.next;

        for (int j = m; j <= n; j++){
            head = head.next;
        }
        ListNode thirdStart = head.next;

        firstEnd.next = null;
        head.next = null;

        ListNode newSecondStart = reverse(secondStart);
        firstEnd.next = newSecondStart;
        secondStart.next = thirdStart;
        return dummyNode.next;
    }

    public static ListNode reverse(ListNode head){
        ListNode curt = head;
        ListNode prev = null;
        ListNode temp;
        while(curt != null){
            temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        return prev;
    }
}
