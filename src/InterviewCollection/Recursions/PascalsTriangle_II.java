package InterviewCollection.Recursions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_II {

    public static void main(String[] args) {
        getRow(5).forEach(System.out::print);
    }

    private static List<Integer> getRow(int rowIndex) {

        if (rowIndex == 0) return null;
        if (rowIndex == 1) return new ArrayList<>(Arrays.asList(1));
        if (rowIndex == 2) return new ArrayList<>(Arrays.asList(1, 1));
        var result = getRow(--rowIndex);

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for (int i = 1; i < rowIndex; i++) {
            temp.add(result.get(i - 1) + result.get(i));
        }
        temp.add(1);

        return temp;
    }
}
