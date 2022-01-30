package InterviewCollection.Graph;

public class QuickUnion {

    int[] root;

    public QuickUnion(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    private int find(int x) {
        while (x != root[x])
            x = root[x];
        return x;
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    private boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
