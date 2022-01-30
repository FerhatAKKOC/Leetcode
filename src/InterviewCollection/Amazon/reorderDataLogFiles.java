package InterviewCollection.Amazon;

import java.util.Arrays;
import java.util.Comparator;

public class reorderDataLogFiles {

    public static void main(String[] args) {

        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};

        String[] output = reorderLogFiles(logs);

        for(var out: output)
            System.out.print(out + " ");
    }

    /*
        Reorder Data in Log Files
     */
    private static String[] reorderLogFiles(String[] logs) {


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                var split1 = o1.split(" ", 2);
                var split2 = o2.split(" ", 2);

                var digit1 = Character.isDigit(split1[1].charAt(0));
                var digit2 = Character.isDigit(split2[1].charAt(0));


                if (!digit1 && !digit2) { // both letter logs

                    int cmp = split1[1].compareTo(split2[1]);

                    if (cmp == 0) { // content equals
                        return split1[0].compareTo(split2[0]);
                    } else {
                        return cmp;
                    }
                }

                if (digit1 && digit2) {
                    return 0;
                } else if (!digit1 && digit2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Arrays.sort(logs, comparator);

        return logs;
    }


}
