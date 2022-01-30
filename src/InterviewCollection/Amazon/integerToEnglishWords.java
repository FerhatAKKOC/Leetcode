package InterviewCollection.Amazon;

import java.util.ArrayList;
import java.util.List;

public class integerToEnglishWords {

    public static void main(String[] args) {
        int num = 1234567891;

        System.out.println("Output: " + numberToWords(1234567891));
    }

    private static String numberToWords(int num) {

        List<String> list = new ArrayList<>();

        getStringValues(num % 1000, list, "");
        num /= 1000;
        if (num > 0) {
            getStringValues(num % 1000, list, "Thousand");
        }
        num /= 1000;
        if (num > 0) {
            getStringValues(num % 1000, list, "Million");
        }
        num /= 1000;
        if (num > 0) {
            getStringValues(num % 1000, list, "Billion");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; 0 <= i; i--) {
            sb.append(list.get(i)).append(" ");
        }

        return sb.toString();
    }

    private static void getStringValues(int num, List<String> list, String str) {

        // Hundred, Thousand, Billion, Million
        String[] values = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteem", "Nineteen", "Twenty"};
        String[] values10 = {"", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        var temp = num % 100;
        list.add(str);
        if (temp <= 20) {
            list.add(values[temp]);
        } else {
            list.add(values[temp % 10]);
            list.add(values10[temp / 10]);
        }
        num /= 100;

        if (num > 0) {
            list.add("Hundred");
            list.add(values[num]);
        }
    }
}
