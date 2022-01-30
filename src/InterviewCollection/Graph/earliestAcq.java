package InterviewCollection.Graph;

import java.util.Arrays;

public class earliestAcq {

    public static void main(String[] args) {
        int[][] logs = {{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}};
        int n = 6;

        System.out.println("Output: " + earliestAcq(logs, n));
    }

    /*
        The Earliest Moment When Everyone Become Friends
        1.sort logs according to timestamp
        2.union element who has the same parent
        3.when there is only one parent done
     */
    private static int earliestAcq(int[][] logs, int n) {

        root = new int[n];
        rank = new int[n];
        component = n;

        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        Arrays.sort(logs, (o1, o2) -> o1[0] - o2[0]);

        for (var log : logs) {
            union(log[1], log[2]);
            if (component == 1) {
                return log[0];
            }
        }

        return -1;
    }

    //*********************************************************
    //*********************************************************

    static int[] root;
    static int[] rank;
    static int component;

    private static int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {

            if (rank[rootX] > rank[rootY])
                root[rootY] = rootX;
            else if (rank[rootX] < rank[rootY])
                root[rootX] = rootY;
            else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            component--;
        }
    }
}
