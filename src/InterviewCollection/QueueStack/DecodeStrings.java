package InterviewCollection.QueueStack;

import java.util.Stack;

public class DecodeStrings {

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";  //   Output: "abcabccdcdcdef"
//        String s = "2[abc]";  //   Output: "abcabccdcdcdef"

        System.out.println("Output : " + decodeString(s));


//        System.out.println((new StringBuilder("abc").reverse().toString()));

    }

    /*
        Input: s = "2[abc]3[cd]ef"
        Output: "abcabccdcdcdef"
     */
    private static String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = s.length() - 1; 0 <= i; i--) {

            var ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                stack.pop();
                StringBuilder sb = new StringBuilder();
                while (true) {
                    if (stack.peek() != ']')
                        sb.append(Character.valueOf(stack.pop()));
                    else {
                        stack.pop();
                        var res = sb.reverse().toString().repeat(Integer.parseInt(String.valueOf(ch))).toCharArray();
                        for (var a : res)
                            stack.push(a);
                        break;
                    }
                }

            } else {
                stack.push(ch);
            }
        }

        var result = new StringBuilder();
        while (!stack.empty())
            result.append(stack.pop());


        return result.toString();
    }

    //**********************************************************************
    //**********************************************************************
    private static String decodeString2(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = s.length() - 1; 0 <= i; i--) {
            var ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    var val = stack.pop();      //  "3[a2[c]]";
                    if (val == '[') continue;
                    if (val == ']') break;
                    sb.append(val);
                }
                var res = sb.reverse().toString().repeat(Character.getNumericValue(ch)).toCharArray();

                for (var a : res)
                    stack.push(a);

            } else {
                stack.push(ch);
            }
        }


        var result = new StringBuilder();
        while (!stack.empty())
            result.append(stack.pop());

        return result.toString();
    }
}

