package InterviewCollection.Design;

import java.util.Stack;

/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class MinStack {

    Stack<Integer> minStack = null;
    Stack<Integer> stack = null;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        int min = val;

        if (!minStack.isEmpty() && min > minStack.peek()) {
            min = val;
        }
        stack.push(val);
        minStack.push(min);
    }

    public void pop() {

        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
