package InterviewCollection.Graph;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class courseSchedule_II {

    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;

        var out = findOrder(numCourses, prerequisites);

        Arrays.stream(out).forEach(value -> System.out.print(value + " "));
    }

    /*
        Kahn's Algoritm BFS
        https://www.youtube.com/watch?v=tggiFvaxjrY
     */
    private static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] courseOrder = new int[numCourses];

        if (prerequisites == null || prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray();
        }

        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        // step-1: Find all indegree
        for (var pre : prerequisites)
            indegree[pre[0]]++;

        // step-2 push all indegree=0 node into queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        if (queue.isEmpty())   // Hiç bir zero indegree yok, bu durumda cycle olma durumu vardır.
            return new int[0];


        // Get adj lists and check them
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            courseOrder[index] = course;
            index++;
            for (int[] pre : prerequisites) {  // check all neighbours
                if (pre[1] == course) {
                    indegree[pre[0]]--;
                    if (indegree[pre[0]] == 0) {
                        queue.offer(pre[0]);
                    }
                }
            }
        }

        //burada connected olmamış bir graph varsa diye onu kontrol ediyorlar, yada Cycle
        for (int in : indegree) {
            if (in != 0) {
                return new int[0];
            }
        }

        return courseOrder;
    }
}
