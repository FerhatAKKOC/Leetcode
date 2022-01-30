package InterviewCollection.CollectionsEasy;

public class hammingDistance {

    public static void main(String[] args) {
        System.out.println("Output: " + hammingDistance2(1, 4));
    }

    private static int hammingDistance(int x, int y) {

        int bitmask = 1;  // 00000000 00000000 00000000 00000001

        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if (((bitmask << i) & x) != ((bitmask << i) & y)) {
                counter++;
            }
        }

        return counter;
    }

    //****************************************************
    //****************************************************
    /*
     * Hamming distance, 2 integer arasındaki farklı bitleri sayar.
     * */
    private static int hammingDistance2(int x, int y) {

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
