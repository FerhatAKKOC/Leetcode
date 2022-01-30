package InterviewCollection.Math;

import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {
    public static void main(String[] args) {

        var result = fizzBuzz(40);

        result.forEach(System.out::print);
    }

    private static List<String> fizzBuzz(int n) {

        // ans list
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {

            if ((num % 3 == 0) && (num % 5 == 0)) {   // Divides by both 3 and 5, add FizzBuzz
                ans.add("FizzBuzz");
            } else if ((num % 3 == 0)) {  // Divides by 3, add Fizz
                ans.add("Fizz");
            } else if ((num % 5 == 0)) {  // Divides by 5, add Buzz
                ans.add("Buzz");
            } else {
                // Not divisible by 3 or 5, add the number
                ans.add(Integer.toString(num));
            }
        }

        return ans;
    }


}
