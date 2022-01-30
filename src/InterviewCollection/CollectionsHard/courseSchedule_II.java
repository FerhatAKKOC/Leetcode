package InterviewCollection.CollectionsHard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class courseSchedule_II {

    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;

        var output = canFinish(numCourses, prerequisites);

        for (var a : output)
            System.out.print(a + " ");
    }

    /*
        Course Schedule II
         0:unvisited,  1:visiting,  2:completed
     */
    private static int[] canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (var pre : prerequisites) {
            var requisits = map.get(pre[0]);
            requisits.add(pre[1]);
        }

        List<Integer> list = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) { // unvisited
                if (false == dfs(map, visited, i, list))
                    return new int[]{};
            }
        }


        return list.stream().mapToInt(value -> value).toArray();
    }

    private static boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int i, List<Integer> list) {

        if (visited[i] == 1)    // Previously visiting. So, there is a circle
            return false;
        else if (visited[i] == 2)  // Previously completed
            return true;

        visited[i] = 1;

        for (var req : map.get(i)) {
            if (visited[req] == 1)
                return false;
            dfs(map, visited, req, list);
        }

        visited[i] = 2;
        list.add(i);
        return true;
    }
}
