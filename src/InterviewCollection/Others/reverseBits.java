package InterviewCollection.Others;

public class reverseBits {

    public static void main(String[] args) {

        int input  = -3;
        System.out.println( input +"  " + Integer.toBinaryString(input));
        System.out.println( ~input +"  " + Integer.toBinaryString(~input));
        System.out.println("------------------");

        System.out.println( reverseBits(input) +"  " + Integer.toBinaryString(reverseBits(input)));

    }

    // Girdiğimiz değerlerin bitlerini değiştiriyoruz. Burada tilda '~' operatörü kullanılabilir.
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