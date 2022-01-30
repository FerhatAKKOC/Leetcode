package InterviewCollection.CollectionsMedium;

public class trailingZeroes {

    public static void main(String[] args) {

        System.out.println("Output: " + trailingZeroes(25));
    }

    /*
     Burada kaç adet 5 var ise, o kadar da sonda '0' vardır. Çünkü '2' çok sayıda var fakat '5' az sayıda. 5*2 = 10'dan bir adet sıfır elde ederiz.
     25 den 2 adet sıfır(25*4) elde ederiz. 125'den 3 adet sıfır(125*8) elde ederiz. İstediğimiz kadar '2' kullanabiliyoruz.
     */
    private static int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            int tmp = n / 5;
            count += tmp;
            n = tmp;
        }
        return count;
    }
}
