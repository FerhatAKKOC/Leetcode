package InterviewCollection.Amazon;

import java.util.*;

public class courseSchedule_I {

    public static void main(String[] args) {

//      int[][] prerequisites = {{1, 0}, {0, 1}}; int numCourses = 2;
        int[][] prerequisites = {{0, 1}, {0, 2}, {0, 3}, {2, 3}};
        int numCourses = 4;

        System.out.println("Output: " + canFinish(numCourses, prerequisites));
    }

    /*
        Course Schedule I
        https://www.youtube.com/watch?v=EgI5nU9etnU

        Kahn's Algortihm Used
     */
    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites == null || prerequisites.length == 0) // There is no prerequest condition, I can directly take all courses
            return true;

        int[] indegree = new int[numCourses];
        for (var pre : prerequisites) {
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (var pre : prerequisites) {
                if (pre[1] == course) {
                    indegree[pre[0]]--;
                    if (indegree[pre[0]] == 0)
                        queue.offer(pre[0]);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
