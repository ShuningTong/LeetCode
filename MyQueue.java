// the original thinking is to move everything from queue to a helper queue, after peek()/pop() operation, move everything back to the queue.
// but Stefan Pochmann has the very neat O(1) algorithm, which is borrowed in the following.
import java.util.Stack;
class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        System.out.println(myQueue.peek());
        myQueue.dequeue();
        System.out.println(myQueue.empty());
        for (int x: myQueue.input){
            System.out.println(x);
        }
        for (int y: myQueue.output){
            System.out.println(y);
        }

    }

    public MyQueue(){
        this.input = new Stack<>();
        this.output = new Stack<>();
    }
    // Push element x to the back of queue.
    public void enqueue(int x) {
        this.input.push(x);
    }

    // Removes the element from in front of queue.
    public void dequeue() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if (output.empty()){
            while(!input.empty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.empty() && output.empty();
    }
}
