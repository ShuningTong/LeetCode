import java.util.LinkedList;
import java.util.Queue;
// this implementation of stack uses linkedlist (as queue)
// this is inspired by Stefan Pochmann's algorithm, but not exactly the same
// https://leetcode.com/discuss/39839/o-1-purely-with-queues
class MyStack {

    public LinkedList<Integer> queue;

    public static void main(String[] args){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
        System.out.println(myStack.empty());
    }

    public MyStack(){
        this.queue = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(x);
        q.addAll(queue);
        queue = q;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();
    }

    // Get the top element.
    public int peek() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
