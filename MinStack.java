import java.util.Stack;
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    public int top() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack.peek();
    }
    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);
        System.out.println("Minimum: " + ms.getMin());
        ms.pop();
        System.out.println("Minimum after pop: " + ms.getMin());
        ms.pop();
        System.out.println("Minimum after pop: " + ms.getMin());
        System.out.println("Top Element: " + ms.top());
    }
}