package InterviewCollection.CollectionsMedium;

public class divide {

    public static void main(String[] args) {
        System.out.println("Output: " + divide(14, 3));
    }

    // Divide Two Integers
    // https://www.youtube.com/watch?v=m4L_5qG4vG8
    private static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;

        int result = 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend >= divisor) {

            int temp = divisor;
            int count = 1;

            while (temp << 1 < dividend) {
                temp <<= 1;
                count <<= 1;
            }

            dividend -= temp;
            result += count;
        }

        return sign == 1 ? result : -result;
    }
}

/*
  Mesala 15/3'ü bulalım.

  - 3'ü geçici bir değikene (temp) atıyoruz. 2 defa sola shift edersek değeri 12 olur. 12 'de 15 den çıkarılabilir.
    2 defa sola shift demek 4 defa bölünebilmesi demek. ilk shift 6 dır. bu durumda 3+3= 6 olduğundan 2 tane quotient (bölüm) gelir.
    Mesala bir defa daha sola shift edersek (3<<2) 12 elde ederiz. (3+3+3+3 = 12) yani 4 defa bölüm gelir. Bir count değerini   count <<= 1; bu şekilde arttırabiliriz.

  - 3. bir shift'de 24 gelir ki bu olmaz, 12 de kalırız
    15-12 dersek 3 kalır. işleme devam ederiz. Eğer 2 kalsaydı işleme outer loop'da devam etmeyecektik. Yani işleme devam etmemiz demek en az bir kere daha quotient olması demektir.

    Aynı işlemleri devam ederek sonucu döneriz.
*/
