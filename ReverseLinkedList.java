/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 9; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println(reverstListRecursive(head));
    }

    // the method using stack
    public static ListNode reverseListStack(ListNode head) {
        if (head == null){
            return null;
        }

        Stack<Integer> stack = new Stack<>();

        while(head != null){
            stack.push(head.val);
            head = head.next;
        }

        head = new ListNode(stack.pop());
        ListNode cur = head;
        while(!stack.empty()){
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return head;
    }

    // the method not using stack
    // we can change this method into a recursive one
    public static ListNode reverseListIterative(ListNode head){
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

    // the recursive method
    public static ListNode reverstListRecursive(ListNode head){
        return recursive(head, null);
    }

    public static ListNode recursive(ListNode head, ListNode newHead){
        if (head == null){
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return recursive(next, head);
    }
}
