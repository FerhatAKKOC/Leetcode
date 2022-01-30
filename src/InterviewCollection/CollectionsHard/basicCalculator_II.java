package InterviewCollection.CollectionsHard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class basicCalculator_II {

    public static void main(String[] args) {
        String s = "  3  +    2 *2  ";
//        String s = "  3  /2";
 //       String s = " 3+5 / 2 ";

        System.out.println("Output: " + calculate(s));
    }

    private static int calculate(String s) {

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        // getting digits and operators
        for (char ch : s.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                } else {
                    list.add(sb.toString());
                    list.add(String.valueOf(ch));
                    sb.delete(0, s.length());
                }
            }
        }

        list.add(sb.toString());

        Stack<Integer> stack = new Stack<>();

        String operation = "+";
        // eval
        for (var str : list) {

            if (str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) {
                operation = str;
            } else {
                int number = Integer.valueOf(str);
//                System.out.println("Number:  " + number);

                switch (operation) {
                    case "+":
                        stack.push(number);
                        break;
                    case "-":
                        stack.push(-number);
                        break;
                    case "*":
                        int prev = stack.pop();
                        stack.push(prev * Integer.valueOf(str));
                        break;
                    case "/":
                        prev = stack.pop();
                        stack.push(prev / Integer.valueOf(str));
                        break;
                    default:
                        System.out.println("Invalid Operation");
                }
            }
        }

        int result = 0;

        while (!stack.isEmpty())
            result += stack.pop();

        return result;

    }
}
