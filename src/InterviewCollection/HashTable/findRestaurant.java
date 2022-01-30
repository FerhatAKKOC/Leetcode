package InterviewCollection.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findRestaurant {

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Burger King", "Tapioca Express", "Shogun", "KFC"};


        var output = findRestaurant1(list1, list2);

        for (var val : output)
            System.out.print(val + " ");


    }

    private static String[] findRestaurant1(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);

        List<String> res = new ArrayList<>();

        int min_sum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                int sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }

        return res.toArray(new String[res.size()]);
    }
    //*****************************************************************************

    private static String[] findRestaurant2(String[] list1, String[] list2) {

        if (list1.length == 0 || list2.length == 0)
            return null;
        if ((list1.length == 1 || list2.length == 1) && list1[0].equals(list1[0]))
            return list1;


        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            var indice2 = findIndex(list2, list1[i]);
            if (indice2 >= 0) {
                map.put(list1[i], i + indice2);
            }
        }

        return null;
    }

    private static int findIndex(String[] arr, String value) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value))
                return i;
        }
        return -1;
    }
}
