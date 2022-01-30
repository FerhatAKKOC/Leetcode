package InterviewCollection.QueueStack;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

        private List<Integer> data;  // store elements
        private int p_start;  // a pointer to indicate the start position

        public MyQueue() {
            data = new ArrayList<Integer>();
            p_start = 0;
        }

        /** Insert an element into the queue. Return true if the operation is successful. */
        public boolean enQueue(int x) {
            return data.add(x);
        };

        /** Delete an element from the queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty() == true) {
                return false;
            }
            p_start++;
            return true;
        }
        /** Get the front item from the queue. */
        public int Front() {
            return data.get(p_start);
        }

        /** Checks whether the queue is empty or not. */
        public boolean isEmpty() {
            return p_start >= data.size();
        }
    };


