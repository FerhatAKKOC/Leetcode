package InterviewCollection.QueueStack;

import java.util.*;

public class KeysAndRooms {

    public static void main(String[] args) {

        List<List<Integer>> rooms =  new ArrayList<>();

//        rooms.add(new ArrayList<>(Arrays.asList(1,3)));
//        rooms.add(new ArrayList<>(Arrays.asList(3,0,1)));
//        rooms.add(new ArrayList<>(Arrays.asList(2)));
//        rooms.add(new ArrayList<>(Arrays.asList(0)));
        rooms.add(new ArrayList<>(Arrays.asList(1)));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(Arrays.asList(3)));
        rooms.add(new ArrayList<>());

        System.out.println("Output : " + canVisitAllRooms(rooms));

    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if(rooms.isEmpty() || rooms.size()==0 || rooms.get(0).size() == 0) return false;



        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for (var key : rooms.get(0))
            queue.offer(key);

        while (!queue.isEmpty()){

            var key = queue.poll();
            set.add(key);

            var keys = rooms.get(key);

            for (var k: keys ){
                if(!set.contains(k)){
                    queue.offer(k);
                    set.add(k);
                }
            }
        }

        set.add(0);
        return set.size() == rooms.size();

    }
}
