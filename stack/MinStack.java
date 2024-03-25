package stack;

public class MinStack {
    private DynamicStack stack = new DynamicStack(5);
    private DynamicStack minTrackStack = new DynamicStack(5);

    //push
    public void push(int element) {
        if(stack.size() == 0) {
            minTrackStack.push(element);
        } else {
            if(element <= minTrackStack.top()) {
                minTrackStack.push(element);
            }
        }
        stack.push(element);
    }
    //pop
    public int pop() {
        int popped = stack.pop();
        if(minTrackStack.top() == popped)
            minTrackStack.pop();
        return popped;
    }
    //top
    public int top() {
        return stack.top();
    }
    //size
    public int size() {
        return stack.size();
    }
    //display
    public void display() {
        stack.display();
    }

    //min
    public int min() {
        if(minTrackStack.size() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return minTrackStack.top();
    }
}

class MinStackClient {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.display();
        System.out.println("Minimum : " + minStack.min());
        minStack.push(-1);
        minStack.push(-2);
        minStack.display();
        System.out.println("Minimum : " + minStack.min());
    }
}
