package InterviewCollection.Graph;

import java.util.*;

public class reconstructItinerary {

    Map<String, List<String>> flightMap = new HashMap<>();
    Map<String, boolean[]> visitMap = new HashMap<>();
    int flightSize;
    List<String> result;

    public static void main(String[] args) {

    }

    /*
        Reconstruct Itinerary
        https://leetcode.com/problems/reconstruct-itinerary/ (çözüm burada)
        https://www.youtube.com/watch?v=WYqsg5dziaQ
     */
    public List<String> findItinerary(List<List<String>> tickets) {

        flightSize = tickets.size();

        // build a graph
        for (var ticket : tickets) {
            var origin = ticket.get(0);
            var destination = ticket.get(1);
            flightMap.putIfAbsent(origin, new ArrayList<>());
            flightMap.get(origin).add(destination);
        }

        // sort destinations according to lexical order
        for (var entry : flightMap.entrySet()) {
            Collections.sort(entry.getValue());
            visitMap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }

        LinkedList<String> route = new LinkedList<>();
        route.add("JFK");

        backtracking("JFK", route);

        return result;
    }

    protected boolean backtracking(String origin, LinkedList<String> route) {

        if (route.size() == flightSize + 1) {
            result = (LinkedList<String>) route.clone();
            return true;
        }

        if (!flightMap.containsKey(origin))
            return false;

        var visited = visitMap.get(origin);
        for (int i = 0; i < flightMap.get(origin).size(); i++) {

            if (visited[i] == false) {  // not visited yet

                var destination = flightMap.get(origin).get(i);

                visited[i] = true;
                route.add(destination);
                var ans = backtracking(destination, route);
                route.pollLast();
                visited[i] = false;

                if(ans)
                    return true;
            }
        }
        return false;
    }
}

