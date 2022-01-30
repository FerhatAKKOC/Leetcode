package InterviewCollection.Amazon;

import java.util.*;

public class FreqStack {

    /*
         Maximum Frequency Stack
         https://www.youtube.com/watch?v=0fRmVjxopiE
     */

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> freqStack;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }

    private void push(int val) {

        int freq = freqMap.getOrDefault(val, 0) + 1;  // 1-) Increment value in freqMap
        freqMap.put(val, freq);

        freqStack.computeIfAbsent(freq, f->new Stack<>()).push(val) ; //2-) Adding value in freqStack

        if (freq > maxFreq) // 3-) Updating the maxFreq
            maxFreq = freq;
    }

    private int pop() {
        var stack = freqStack.get(maxFreq);
        var val = stack.pop();
        if (stack.isEmpty() && maxFreq > 0)
            maxFreq--;

        freqMap.put(val, freqMap.get(val) - 1);
        return val;
    }
}
