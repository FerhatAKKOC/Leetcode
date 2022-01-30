package InterviewCollection.company;

import java.util.*;

public class booking {

    public static void main(String[] args) {


        int[] cars = Arrays.asList(10, 2, 8, 17).stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Output: " + findMinRoofLength(cars, 3));

//        System.out.println("Output: " + findTFreqCharacter("aabbcdfgghk"));
    }


    /*
    1. Soru

    En çok tekrar eden ilk karakteri bulmamızı istiyor. String veriyor. Burada eğer iki tane karakter aynı sayıda ise
    string'de yer alan ilk karakteri dönmemiz gerekir.
    "aaajlldfjjeee" Mesala 'a' ve 'e' aynı sayıda. burada istenilen cevap 'a' dır.
*/
    private static char findTFreqCharacter(String str) {

        var series = str.toCharArray();

        char maxChar = series[0];
        int maxRepeat = Integer.MIN_VALUE;
        int counter = 0;

        for (int i = str.length() - 1; 0 < i; i--) {

            if (series[i] == series[i - 1]) {
                counter++;
            } else {
                if (counter > maxRepeat)
                    maxChar = series[i];

                counter = 0;
            }
        }
        if (counter > maxRepeat)
            maxChar = series[0];

        return maxChar;
    }

/*
    2. soru:

    Roofing parking sorusu.

        En kısa roof uzunluğu ile istenildiği kadar arabanın üstünü örtmemizi istiyor.
        2 adet nested for loop yaparak çözülebilir.
        k: bulunan tek parça roof, bu kadar aracı kapsamalı. Yani minimum roof ile bu kadar aracı nasıl kapsayabiliriz.

        Mesala: [10,2,8,17] gibi bir giriş olsun
     */

    private static int findMinRoofLength(int[] cars, int k) {

        Arrays.sort(cars);
//    Arrays.stream(cars).forEach(System.out::print);
        Deque<Integer> queue = new ArrayDeque<>();

        int minLength = Integer.MAX_VALUE;

        for (var car : cars) {

            queue.offer(car);

            if (queue.size() >= k) {
                int first = queue.pollFirst();
                int last = queue.peekLast();

                int len = last - first + 1;

                if (len < minLength)
                    minLength = len;
            }
        }

        return minLength;
    }
}
