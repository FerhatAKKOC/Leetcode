package InterviewCollection.CollectionsMedium;

import java.util.ArrayList;
import java.util.List;

public class sumTwoIntegers {

    public static void main(String[] args) {

        System.out.println("Output: " + getSum(2, 3));

//        int local = 0b00001111;
//        System.out.println("local: " + Integer.toBinaryString(local & 1));
    }

    /*
    https://www.youtube.com/watch?v=qq64FrA2UXQ&t=1035s
     */
    private static int getSum(int a, int b) {

        while (b != 0) {

            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
