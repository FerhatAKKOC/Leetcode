package InterviewCollection.Others;

public class hammingDistance {

    public static void main(String[] args) {
        int x = 3;
        int y = 1;

        System.out.println("Output : " + hammingDistance(x, y));

    }

    /*
    * Hamming distance, 2 integer arasındaki farklı bitleri sayar.
    * */
    private static int hammingDistance(int x, int y) {

        int temp = x ^ y;
        System.out.println(Integer.toBinaryString(temp));

        return countOnes(temp);
    }

    private static int countOnes(int temp) {

        int mask = 1;  // 00000000 00000000 00000000 00000100
        int bits = 0;

        for (int i = 0; i < 32; i++) {
            if ((mask & temp) != 0)
                bits++;
            mask <<= 1;
        }

        return bits;
    }
}
