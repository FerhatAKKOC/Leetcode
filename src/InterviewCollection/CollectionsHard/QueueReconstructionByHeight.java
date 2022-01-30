package InterviewCollection.CollectionsHard;

import java.util.*;
import java.util.stream.Collectors;

public class QueueReconstructionByHeight {

    public static void main(String[] args) {

//        int[][] people = {{2, 2}, {6, 0}, {5, 0}, {1, 4}, {4, 0}, {3, 2}};
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        var output = reconstructQueue(people);
    }

    /*
        Queue Reconstruction by Height

        https://www.youtube.com/watch?v=_DtZIPUt8jo
     */
    private static int[][] reconstructQueue(int[][] people) {

        int n = people.length;

        List<int[]> queue = new ArrayList<>();

        Arrays.sort(people, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];    // Büyükten küçüğe doğru sıralıyoruz, ilk index'ler eşitse, 2. indexlerde küçükten büyüğe doğru sıralıyoruz
        });


        for (var person : people) {         // Temel mantık, height küçük bir eleman, büyük elemanların önüne gelebilir ve onları etkilemez.
            queue.add(person[1], person);
        }


        return queue.toArray(new int[n][2]);
    }
}
