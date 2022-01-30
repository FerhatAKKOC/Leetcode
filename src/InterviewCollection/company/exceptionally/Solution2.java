package InterviewCollection.company.exceptionally;

public class Solution2 {

    public static void main(String[] args) {

        System.out.println("Output:" + SpecialNumbers(4, 7, 8));
    }


    static long SpecialNumbers(int Number, int DecreasingCost, int IncreasingCost) {

        if (isSpecial(Number))
            return 0;

        int incCount = 0;
        int decCount = 0;

        while (!isSpecial(Number)){
            incCount++;
            Number++;
        }

        return incCount*IncreasingCost;
    }


    static int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++)
            result *= i;

        return result;
    }

    static boolean isSpecial(int number) {
        int total = 0, x = number;
        while (x != 0) {
            total += factorial(x % 10);
            x /= 10;
        }
        return (total == number);
    }

}
