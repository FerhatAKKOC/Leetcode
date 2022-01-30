package InterviewCollection.QueueStack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {


    public static void main(String[] args) {
        StackUsingQueues myStack = new StackUsingQueues();
        myStack.push(1);
        myStack.push(2);

        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }

    Queue<Integer> queue;
    Queue<Integer> backup;
    /**
     * Initialize your data structure here.
     */
    public StackUsingQueues() {
        queue = new LinkedList<>();
        backup = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        backup.clear();

        while (!queue.isEmpty())
            backup.offer(queue.poll());

        queue.clear();
        queue.offer(x);
        while (!backup.isEmpty())
            queue.offer(backup.poll());
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }


}
