package stack;

public class FixedSizeStack {
    private int[] data;
    private int tos = -1;
    public FixedSizeStack(int capacity) {
        data = new int[capacity];
    }

    //push
    public void push(int element) {
        if(tos == data.length - 1) {
            System.out.println("Stack Overflow");
        } else {
            tos++;
            data[tos] = element;
        }
    }

    //pop
    public int pop() {
        if(tos == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int top = data[tos];
            tos--;
            return top;
        }
    }

    //top
    public int top() {
        if(tos == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return data[tos];
        }
    }

    //size
    public int size() {
        return tos + 1;
    }

    public void display() {
        for(int i = tos; i >= 0; i--) {
            System.out.printf("%d ", data[i]);
        }
        System.out.println();
    }
}

class FixedStackClient {
    public static void main(String[] args) {
        FixedSizeStack stack = new FixedSizeStack(5);
        // stack.pop(); // stack underflow
        // stack.top(); // stack underflow
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(-2);
        stack.push(-1);
        // stack.push(6); // stack overflow
        System.out.println("Size : " + stack.size());
        stack.display();
    }
}
