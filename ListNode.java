import java.lang.StringBuilder;


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString(){
        ListNode curNode = this;
        StringBuilder sb = new StringBuilder();
        while (curNode != null){
            sb.append(curNode.val + " -> ");
            curNode = curNode.next;
        }
        return sb.toString();
    }
}
