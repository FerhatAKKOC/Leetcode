package InterviewCollection.QueueStack;

import java.util.Stack;

public class QueueUsingStacks {

    public static void main(String[] args) {
        QueueUsingStacks myQueue = new QueueUsingStacks();
        myQueue.push(3); // queue is: [1]
        myQueue.push(5); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(6); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(23); // queue is: [1, 2] (leftmost is front of the queue)

        System.out.println(myQueue.peek()); // return 1;
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println("Empty : " + myQueue.empty()); // return false
    }

    Stack<Integer> stack;
    Stack<Integer> backup;

    /**
     * Initialize your data structure here.
     */
    public QueueUsingStacks() {
        stack = new Stack<>();
        backup = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {

        if (!stack.empty()) {
            backup.clear();
            while (!stack.empty())
                backup.push(stack.pop());
        }
        stack.push(x);

        while (!backup.empty())
            stack.push(backup.pop());
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.empty();
    }
}
