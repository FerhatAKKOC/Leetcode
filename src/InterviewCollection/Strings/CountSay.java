package InterviewCollection.Strings;

public class CountSay {

    /*
        countAndSay(1) = "1"
        countAndSay(2) = say "1" = one 1 = "11"
        countAndSay(3) = say "11" = two 1's = "21"
        countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

         1.     1  ->   (one one)   (times,Char)
         2.     11  ->  (two one) 21   (times,Char)
         3.     21  ->  (one two) (one one) 1211 (times,Char) (times,Char)
         4.     1211 -> (one one) (one two) (two one) 111221 (times,Char)(times,Char)(times,Char)
         5.     111221
         6.     312211
         7.     13112221
         8.     1113213211
         9.     31131211131221
        10.     13211311123113112211

     */

    public static void main(String[] args) {
        countAndSay(6);
    }


    // HashMap for solution Map<Times,Characters> -> collect result

    static String countAndSay(int n) {

        var result = "1";
        if (n == 1) return result;

        while (n > 1) {    // steps,n, iteration

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < result.length(); i++) { // string iteration for determine (repeat, character)

                int counter = 1;

                while (i + 1 < result.length() && result.charAt(i) == result.charAt(i + 1)) {
                    counter++;
                    i++;
                }
                sb.append(counter).append(result.charAt(i));
            }

            result = sb.toString();
            System.out.println(sb.toString());

            n--;
        }


        return null;
    }


}
