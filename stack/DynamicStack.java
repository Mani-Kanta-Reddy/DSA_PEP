package stack;

public class DynamicStack {
    private int[] data;
    private int tos = -1;
    public DynamicStack(int initialCapacity) {
        data = new int[initialCapacity];
    }

    // push
    public void push(int element) {
        if(tos == data.length - 1) {
            // time to grow
            int[] temp = new int[data.length * 2];
            for(int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        tos++;
        data[tos] = element;
    }
    // pop
    public int pop() {
        if(tos == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int top = data[tos];
        tos--;
        return top;
    }
    // top
    public int top() {
        if(tos == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return data[tos];
    }

    // size
    public int size() {
        return tos + 1;
    }

    // display
    public void display() {
        for(int i = tos; i >= 0; i--) {
            System.out.printf("%d ", data[i]);
        }
        System.out.println();
    }

}
class DynamicStackClient {
    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack(5);
        // stack.pop(); // stack underflow
        // stack.top(); // stack underflow
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.display();
        System.out.println("Top : " + stack.top());
        System.out.println("Size : " + stack.size());
        System.out.println("Popped Item : " + stack.pop());
        System.out.println("Pushing an element");
        stack.push(-1);
        stack.display();
    }
}
