package InterviewCollection.Amazon;

import java.util.*;
import java.util.stream.Collectors;

public class cutOffTree {

    public static void main(String[] args) {

        List<List<Integer>> forest = new ArrayList<>();
        forest.add(Arrays.asList(1,2,3));
        forest.add(Arrays.asList(0,0,0));
        forest.add(Arrays.asList(7,6,5));

        System.out.println("Output: " + cutOffTree(forest));
    }

    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /*
        Cut Off Trees for Golf Event
        Since we have to cut trees in order of their height, we first put trees (int[] {row, col, height}) into a priority queue and sort by height.
        Poll each tree from the queue and use BFS to find out steps needed.

        İki adet Queue yaratmamızın nedeni '1' değerlerinin üzerinden geçebiliyoruz. 2 1 3 gibi bir durumda 2->3 'e gidebilmemiz lazım. step=2 dönüyor bu durumda.
     */
    public static int cutOffTree(List<List<Integer>> forest) {

        if (forest == null || forest.size() == 0)
            return 0;

        int m = forest.size();
        int n = forest.get(0).size();

        // order according to their height
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }

        int[] start = new int[2]; //  {0,0} indexini ifade ediyor.
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = minStep(forest, start, tree, m, n);

            if (step < 0) return -1;
            sum += step;

            start[0] = tree[0];
            start[1] = tree[1];
        }

        return sum;
    }

    private static int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {


        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        int step = 0;
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] curr = queue.poll();

                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;

                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            step++;
        }

        return -1;
    }
}
