package InterviewCollection.CollectionsEasy;

public class hammingWeight {

    public static void main(String[] args) {

        System.out.println("Output: " + hammingWeight(-3));
    }

    // integer değerleri bit seviyesinde yazıp, içerisinde kaç adet '1' var, onu buluyoruz.
    private static int hammingWeight(int n) {

        int counter = 0;
        int bitmask = 1;

        for (int i = 0; i < 33; i++) {

            if (( (bitmask << i) & n) > 0) {
                counter++;
            }
        }
        return counter;
    }

}
