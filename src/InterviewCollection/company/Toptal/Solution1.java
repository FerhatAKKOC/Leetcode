package InterviewCollection.company.Toptal;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
//        String S = "id,name,age,act.,room,dep.\n1,Jack,68,T,13,8\n17,Betty,28,F,15,7";
//        String C = "age";


        String S = "area,land\n3722,CN\n6612,RU\n3855,CA\n3797,USA";
        String C = "area";

        System.out.println("Output: : " + solution(S, C));
    }
    /*Codelity*/
    private static int solution(String S, String C) {

        var lines = S.split("\\R"); // separate according to new line

        var colName = lines[0].split(","); // separate each line according to ','

        int index = Arrays.asList(colName).indexOf(C);  // find C index
        System.out.println("Index: " + index);

        int maxValue = Integer.MIN_VALUE;

        for (int i = 1; i < lines.length; i++) {

            var line = lines[i].split(",");
            var value = Integer.valueOf(line[index]);
            System.out.println("Value: " + value);

            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;  // return max value.
    }
}
