package InterviewCollection.ArrayStrings;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {

        var outerList = generate(5);

        for (var smallerList : outerList) {
            for (var item : smallerList)
                System.out.print(item + " ");
            System.out.println();
        }

    }

    private static List<List<Integer>> generate(int numRows) {

        List<Integer> result = new ArrayList<>();
        result.add(1);

        List<List<Integer>> list = new ArrayList<>();
        list.add(result);

        for (int i = 0; i < numRows; i++) {
            list.add(helper(list.get(i)));
        }

        return list;
    }

    private static List<Integer> helper(List<Integer> rows) {

        List<Integer> result = new ArrayList<>();

        if (rows.size() == 1) {
            result.add(1);
            result.add(1);
        } else {
            result.add(1);
            for (int i = 0; i < rows.size() - 1; i++) {
                var temp = rows.get(i) + rows.get(i + 1);
                result.add(temp);
            }
            result.add(1);
        }

        return result;
    }
}
