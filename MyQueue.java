import java.util.Stack;
public class MyQueue {
    Stack<Integer>inputStack;
    Stack<Integer> outputStack;
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    public void push(int x) {
        inputStack.push(x);
    }
    public int pop() {
        if (outputStack.isEmpty()) {  //check this empty 
            while (!inputStack.isEmpty()) { 
                outputStack.push(inputStack.pop());//remove the forst 30 add out putstacj 30 outpustack 30 ,20,10
            }
        }
        return outputStack.pop();
    }
    // Front element
    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }
    // Is Queue Empty?
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println(queue.pop());   //10
        System.out.println(queue.peek());  //20
        System.out.println(queue.pop());   //20
        System.out.println(queue.empty()); //false
    }
}
