package InterviewCollection.QueueStack;

import java.util.*;

public class ReversePolishNotation {

    private static Set<String> set;

    public static void main(String[] args) {

        set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");


        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}; // Output: 22

        System.out.println("Output : " + evalRPN(tokens));

    }


    private static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (var str : tokens) {

            if (stack.isEmpty() || !set.contains(str))
                stack.push(Integer.valueOf(str));
            else {
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());

                int res = eval(num2, num1, str);
                stack.push(res);

            }
        }

        return stack.pop();
    }

    private static int eval(int num1, int num2, String operator) {

        int result = 0;

        switch (operator) {
            case "+": {
                result = num1 + num2;
                break;
            }
            case "-": {
                result = num1 - num2;
                break;
            }
            case "*": {
                result = num1 * num2;
                break;
            }
            case "/": {
                result = num1 / num2;
                break;
            }
        }

        System.out.println(num1 + operator + num2 + " = " + result);
        return result;
    }
}
