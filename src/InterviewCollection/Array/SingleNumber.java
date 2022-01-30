package InterviewCollection.Array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    /*
        Input: nums = [4,1,2,1,2]  Find that single one.
        Output: 4
     */

    public static void main(String[] args) {
        int [] nums = new int[] {4,1,2,1,3,2,4};
        var result = singleNumber1(nums);
    }

    /*
     Using Map<Key,Value>
     2 nested for loop O (n^2)
     Streams-> Count
    * */
    public static int singleNumber(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for(var a : nums){

            if(map.containsKey(a)){
                map.put(a,2);
            }
            else {
                map.put(a,1);
            }
        }

        var res = map.entrySet().stream().min((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        res.ifPresent(System.out::println);


        int result=0;
        for (var entry : map.entrySet()){
            if (entry.getValue() == 1){
                result = entry.getKey();
            }
        }

        System.out.println("Result : " + result);

        return result;
    }

    public static int singleNumber1(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for(var a : nums){

            if(map.containsKey(a)){
                map.put(a,2);
            }
            else {
                map.put(a,1);
            }
        }

        var res = map.entrySet().stream().min((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        System.out.println(res.get().getKey());

        return  res.isPresent() ? res.get().getKey() : 0;
    }
}
