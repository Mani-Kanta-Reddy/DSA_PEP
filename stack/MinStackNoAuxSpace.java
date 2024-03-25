package stack;

public class MinStackNoAuxSpace {
    private DynamicStack stack = new DynamicStack(5);
    private int min = -1;
    // push
    public void push(int element) {
        if(stack.size() == 0) {
            stack.push(element);
            min = element;
        } else {
            if(element < min) {
                // push marker (v + v - min) value (note: marker is used again for detection and retrieve original value)
                stack.push(element + element - min);
                // update min
                min = element;
            } else {
                stack.push(element);
            }
        }
    }

    // pop
    public int pop() {
        if(stack.size() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        // if original val
        if (stack.top() >= min) {
            return stack.pop();
        }
        // if marker val
        // pop adjust min & return original value
        int markerVal = stack.pop();
        int originalVal = min;
        min = 2 * min - markerVal; // 2v - (v + v -m) => m
        return originalVal;
    }

    // top
    public int top() {
        if(stack.size() == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        // if marker value
        return Math.max(stack.top(), min);
    }
    // size
    public int size() {
        return stack.size();
    }
    // display
    public void display() {
        stack.display();
    }

    //min
    public int min() {
        return min;
    }
}

class MinStackNoAuxSpaceClient {
    public static void main(String[] args) {
        MinStackNoAuxSpace stack = new MinStackNoAuxSpace();
        // stack.pop(); // stack underflow
        // stack.top(); // stack underflow
        stack.push(9);
        stack.push(7);
        stack.push(11);
        System.out.println(stack.min());
        System.out.println("Popped Item : " + stack.pop());
        System.out.println("Top Item : " + stack.top());
        System.out.println("Size : " + stack.size());
        stack.display(); // Note : stack may contain different values from what we inserted, and those are marker values (v + v - m)
    }
}