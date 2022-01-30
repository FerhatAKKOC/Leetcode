package InterviewCollection.Others;

public class hammingWeight {
    public static void main(String[] args) {

        System.out.println("Output:" + hammingWeight(-3));
    }


    private static int hammingWeight(int n) {

        int bits = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {

            if ((mask & n) != 0) {  // bunun sonucu negatifte gelebilir, bundan dolayı sıfırdan farkı olup olmadığına bak
                bits++;
            }
            mask <<= 1;
        }

        return bits;
    }
}
