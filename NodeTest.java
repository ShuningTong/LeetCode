

public class NodeTest{
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        System.out.println("n1's val is: " + n1.val);
        n1.next = n2;
        System.out.println("n2's val is: " + n2.val);
        ListNode ptr = n1;
        System.out.println("ptr's val is: " + ptr.val);
        System.out.println("________________________");
        ptr = ptr.next;
        System.out.println("ptr's val is: " + ptr.val);
        System.out.println("n1's val is: " + n1.val);
        System.out.println("n2's val is: " + n2.val);

        System.out.println("________________________");
        ListNode n4 = null;
        swap(n2, n4);
        System.out.println("after swapping n2 and n4: n2 = " + n2 + " n4 = " + n4);

        System.out.println("________________________");
        System.out.println("after changing n2, does n1's next change?: " + n1.next.val);
    }

    public static void swap(ListNode small, ListNode big){
        ListNode temp = small;
        small = big;
        big = temp;
    }
}
