package InterviewCollection.CollectionsHard;

public class decodeWays {

    public static void main(String[] args) {

        System.out.println("Output : " + numDecodings("123"));
    }

    /*
        Decode Ways
        https://www.youtube.com/watch?v=o1i7JYWbwOE  (Fibonacci Series)
     */
    private static int numDecodings(String s) {


        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;

        if (s.length() == 1)
            return 1;

        int count1 = 1;
        int count2 = 1;

        for (int i = 1; i < s.length(); i++) {

            int d = s.charAt(i) - '0'; // 1<=  d <=9
            int dd = (s.charAt(i - 1) - '0') * 10 + d; // 10<=  d <=26

            int count = 0;

            if (0 < d && d <= 9)  // Eğer sona sadece bir adet '0' eklenirse, bir önceki alternatifleri 0 yapar. Zaten count=0 olarak başladık. Sonraki çift digit^'e etki etmeyecek.
                count = count2;

            if (10 <= dd && dd <= 26)  // eğer '123' durumunda '0' eklenirse, '30' değeri olmaz. Zaten '0' tel digitte bir öncekileri sıfır getirmiştir
                count += count1;

            count1 = count2;
            count2 = count;
        }

        return count2;
    }
}
