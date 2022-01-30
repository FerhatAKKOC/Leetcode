package InterviewCollection.CollectionsEasy;

public class reverseBits {

    public static void main(String[] args) {

        var a = 0b00000010100101000001111010011100;

        System.out.println(a + " >= " + Integer.toBinaryString(a));
        System.out.println(~a + " >= " + Integer.toBinaryString(~a));

    }

    private static int reverseBits(int n) {

        int result = 0;
        int mask = 1; // ... 0000 0001
        for (int i = 0; i < 32; i++) {

            if ((mask & n) == 0) {
                result += mask;  // sıfırları bir yapıyoruz, onuda result isimli başka bir değişkenle topluyoruz.
            }
            mask <<= 1;
        }
        return result;
    }
}
