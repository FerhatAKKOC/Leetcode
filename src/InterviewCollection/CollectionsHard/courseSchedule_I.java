package InterviewCollection.CollectionsHard;

import java.util.*;

public class courseSchedule_I {

    public static void main(String[] args) {

//          int[][] prerequisites = {{1, 0}, {0, 1}}; int numCourses = 2;
        int[][] prerequisites = {{0, 1}, {0, 2}, {0, 3}, {2, 3}};
        int numCourses = 4;

        System.out.println("Output: " + canFinish(numCourses, prerequisites));
    }

    /*
        Course Schedule
        https://www.youtube.com/watch?v=EgI5nU9etnU

        0:unvisited,  1:visiting,  2:completed
     */
    private static boolean canFinish(int numCourses, int[][] prerequisites) {


        Map<Integer, List<Integer>> map = new HashMap<>();

        // map'i course ve prerequestler ile dolduruyoruz
        for (var item : prerequisites) {
            map.putIfAbsent(item[0], new ArrayList<>());
            map.get(item[0]).add(item[1]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (dfs(map, visited, i) == false)
                    return false;
            }
        }

        return true;
    }

    private static boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int i) {

        if (visited[i] == 1)
            return false;   // Previously visited. So, there is a circle

        visited[i] = 1;  // mark as a visiting

        for (var pre : map.get(i)) {
            if (visited[pre] == 1)
                return false;
            dfs(map, visited, pre);
        }

        visited[i] = 2;

        return true;
    }

}
