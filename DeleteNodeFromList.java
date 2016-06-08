/**
 * Definition for singly-linked list.
 * 
 */
import java.util.Scanner;

public class DeleteNodeFromList {
    ListNode root;
    ListNode lastNode;

    public DeleteNodeFromList (int rootValue) {
        root = new ListNode(rootValue);
        lastNode = root;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void addNode(int nodeValue){
        lastNode.next = new ListNode(nodeValue);
        lastNode = lastNode.next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void printList(){
        ListNode curNode = this.root;
        System.out.print(curNode.val + "->");
        while(curNode.next != null){
            System.out.print(curNode.next.val + "->");
            curNode = curNode.next;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a list(separated by space):");
        String input = sc.nextLine();
        String[] listValues = input.split(" "); 
        int rootValue = Integer.parseInt(listValues[0]);
        DeleteNodeFromList newDelete = new DeleteNodeFromList(rootValue);

        for (int i = 1; i < listValues.length; i++){
            newDelete.addNode(Integer.parseInt(listValues[i]));
        }
        newDelete.printList();
        System.out.println("\nWhich node do you want to delete (index)?");
        int nodeIndex = sc.nextInt();
        ListNode curNode = newDelete.root;
        for (int i = 0; i < nodeIndex; i++){
            curNode = curNode.next;
        }
        newDelete.deleteNode(curNode);
        newDelete.printList();
    }
}
