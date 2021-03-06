import java.util.Stack;
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public static void main(String[] args){
        MinStack newStack = new MinStack();
        newStack.push(-2);
        newStack.push(0);
        newStack.push(-3);
        System.out.println(newStack.getMin());
        newStack.pop();
        System.out.println(newStack.top());
        System.out.println(newStack.getMin());
    }

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else{
            minStack.push(Math.min(x, minStack.peek()));
        }
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
