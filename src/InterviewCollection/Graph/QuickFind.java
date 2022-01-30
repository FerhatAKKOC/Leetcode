package InterviewCollection.Graph;

public class QuickFind {

    public static void main(String[] args) {
        QuickFind uf= new QuickFind(10);
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);

        uf.union(9, 4);
    }

    int[] root;

    public QuickFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    private int find(int x) {
        return root[x];
    }

    private void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {

            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY)
                    root[i] = rootX;
            }
        }
    }

    private boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
