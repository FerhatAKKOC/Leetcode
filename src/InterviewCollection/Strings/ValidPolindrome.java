package InterviewCollection.Strings;

public class ValidPolindrome {

    /*  Tersten ve düzden okunuşu aynı
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.

        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.
     */

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";


        System.out.println("\nOutput : " + isPalindrome(s));
    }


    // checking null, empty ->false
    // remove comma, whitespace and all characters which are not alphanumerics
    // compare with a copy of its reverse

    static boolean isPalindrome(String s) {

        if (s == null || s.isEmpty()) return false;

        // Remove all alphanumeric characters
        // str = str.replaceAll("[^a-zA-Z0-9]", "");

        StringBuilder builder = new StringBuilder();
        for (var c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                builder.append(c);
            }
        }



        var check = builder.reverse().toString().equals(builder.toString());
//        System.out.println("Check : " + check);

        return check;
    }

}
