package InterviewCollection.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriange {

    public static void main(String[] args) {
        var Output = generate(5);

        for(var list : Output){
            for (var element : list)
                System.out.print(" " + element);

            System.out.println();
        }
    }

    private static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 1; i < numRows; i++) {
            list.add(gen(list.get(i-1)));
        }

        return list;
    }

    private static List<Integer> gen(List<Integer> input) {
        int size = input.size();

        if (size+1 == 2)
            return new ArrayList<>(Arrays.asList(1, 1));
        else {
            List<Integer> temp = new ArrayList<>();

            temp.add(input.get(0));
            for (int i = 0; i < size - 1; i++) {
                temp.add(input.get(i) + input.get(i + 1));
            }
            temp.add(input.get(size - 1));
            return temp;
        }
    }
}
