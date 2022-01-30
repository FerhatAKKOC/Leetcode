package InterviewCollection.CollectionsMedium;

import java.util.stream.IntStream;

public class findCelebrity {

    // Person with 2 is celebrity
    static int MATRIX[][] = {
            {0, 0, 1, 0},   // A : 0
            {0, 0, 1, 0},   // B : 1
            {0, 0, 0, 0},   // C : 2
            {0, 0, 1, 0}};  // D : 3

    static boolean knows(int a, int b) {
        return MATRIX[a][b] == 1;
    }

    public static void main(String[] args) {
        System.out.println("Output: " + findCelebrity(4));
    }

    /*
    https://www.youtube.com/watch?v=LtGnA5L6LIk
     */

    private static int findCelebrity(int n) {

        var guests = IntStream.rangeClosed(0, n);

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            if (knows(low, high)) {
                low++;  // If A knows B, then A can't be celebrşity, Discard A and B maybe celebrity
            } else {
                high--;  // If A doesn't know B, then B can't be celebrity, Discard B and A mabye celebrity
            }

            if (low == high)
                break;
        }

        for (int i = 0; i < n - 1; i++) {
            if (knows(low, i))  // break'e girmeden döngü kırılmış olabilir.
                return -1;
        }


        return low;
    }
}

/*
Suppose you are at a party with "n" people (labeled from 0 to n - 1) and among them, there may exist one celebrity. T
he definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one.
The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper functionbool knows(a, b)which tells you whether A knows B.
 Implement a functionint findCelebrity(n), your function should minimize the number of calls toknows.

Note: There will be exactly one celebrity if he/she is in the party.
Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return-1.
 */