package InterviewCollection.Graph;

import java.util.Arrays;

public class numberOfProvinces {
    public static void main(String[] args) {

        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println("Output: " + findCircleNum(isConnected));
    }


    static int[] root;

    /*
        Number of Provinces
       2. çözüm https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3846/
     */

    private static int findCircleNum(int[][] M) {

        root = new int[M.length];
        Arrays.fill(root, -1);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j)
                    union(i, j);
            }
        }
        return (int) Arrays.stream(root).filter(x -> x == -1).count();
    }

    private static int find(int x) {
        if (root[x] == -1)
            return -1;
        return find(root[x]);
    }

    private static void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }


}
