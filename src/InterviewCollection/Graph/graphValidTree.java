package InterviewCollection.Graph;

import java.nio.file.FileAlreadyExistsException;
import java.util.*;

public class graphValidTree {


    //**********************************************************
    // Iterative depth-first search
    //**********************************************************
    public boolean validTree1(int n, int[][] edges) {

        List<List<Integer>> neighboursList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighboursList.add(new ArrayList<>());
        }
        for (var edge : edges) {
            neighboursList.get(edge[0]).add(edge[1]);
            neighboursList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {

            var node = stack.pop();

            for (var neigh : neighboursList.get(node)) {

                if (parent.get(node) == neigh)  // neighbour'tan parent'a ziyaret gerçekleşmeyecek.
                    continue;
                if (parent.containsKey(neigh)) // Eğer iki kere kayıt yapmaya çalışmışsak, farklı yollardan o node'a erişmiş sayılırız.
                    return false;

                stack.push(neigh);
                parent.put(neigh, node);
            }
        }
        return parent.size() == n;
    }

    /*
         Advanced Graph Theory + Iterative Depth-First Search

         Bu teoride kodun başında edge sayısını kontrol ediyoruz. edge = nodes-1'dir. edge<n-1 ise not fully connected, edge>n-1 ise there is trivial cycle
         Kodun en başında kontrol ettiğimiz için tek bir şey kalıyor, o da bütün node'ları ziyaret edebiliyor muyuz?
         Onu'da bir set yardığımı ile yapıyoruz. Eğer set.size=node sayısı ise bütün nodeları ziyaret ediyoruz. Sanki directed graph gibi düşünüyoruz.

     */
    public boolean validTree1_1(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        // Make the adjacency list.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(0);
        seen.add(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbour : adjacencyList.get(node)) {
                if (seen.contains(neighbour)) continue;
                seen.add(neighbour);
                stack.push(neighbour);
            }
        }

        return seen.size() == n;
    }

    //**********************************************************
    // Recursive depth-first search
    //**********************************************************
    List<List<Integer>> neighbourList = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();

    public boolean validTree2(int n, int[][] edges) {

        for (int i = 0; i < n; i++) {
            neighbourList.add(new ArrayList<>());
        }
        for (var edge : edges) {
            neighbourList.get(edge[0]).add(edge[1]);
            neighbourList.get(edge[1]).add(edge[0]);
        }

        return dfs(0, -1) && seen.size() == n;
    }

    private boolean dfs(int node, int parent) {

        if (seen.contains(node))
            return false;
        seen.add(node);

        for (var neigh : neighbourList.get(node)) {
            if (neigh != parent) {  // node'un neighbour'u parent olmamalıdır. Parent'u engelliyoruz.
                var result = dfs(neigh, node);
                if (!result) return false;
            }
        }
        return true;
    }

    /*
        Recursive Depth-First Search.

        Kodun başında edge sayısını kontrol ettiğimiz için cycle ve fully connected kontrol ediyoruz.
        Bütün node'ları ziyaret edebiliyor muyuz, onun kontrolünü yapıyoruz.
     */

    private List<List<Integer>> adjacencyList = new ArrayList<>();

    public boolean validTree2_2(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        // Make the adjacency list.
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        // Carry out depth first search.
        dfs(0);
        // Inspect result and return the verdict.
        return seen.size() == n;
    }

    public void dfs(int node) {
        if (seen.contains(node)) return;
        seen.add(node);
        for (int neighbour : adjacencyList.get(node)) {
            dfs(neighbour);
        }
    }

    //**********************************************************
    // Iterative breadth-first search
    //**********************************************************
    public boolean validTree3(int n, int[][] edges) {

        List<List<Integer>> neighbourList = new ArrayList<>();
        Map<Integer, Integer> parent = new HashMap<>();

        for (int i = 0; i < n; i++) {
            neighbourList.add(new ArrayList<>());
        }
        for (var edge : edges) {
            neighbourList.get(edge[0]).add(edge[1]);
            neighbourList.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {

            var node = queue.poll();

            for (var neig : neighbourList.get(node)) {

                if (parent.get(node) == neig)
                    continue;

                if (parent.containsKey(neig))
                    return false;

                queue.offer(neig);
                parent.put(neig, node);
            }
        }
        return parent.size() == n;
    }

    /*
        Iterative Breadth-First Search.
     */
    public boolean validTree3_3(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        // Make the adjacency list.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(0);
        seen.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adjacencyList.get(node)) {
                if (seen.contains(neighbour)) continue;
                seen.add(neighbour);
                queue.offer(neighbour);
            }
        }

        return seen.size() == n;
    }

    //**********************************************************
    // Union Find
    //**********************************************************

    public boolean validTree_Union(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        UnionFind uf = new UnionFind(n);

        for(var edge:edges){
            if(!uf.union(edge[0],edge[1]))
                return false;
        }
        return true;
    }


    class UnionFind {

        int[] root;
        int[] rank;

        public UnionFind(int size) {

            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }

        private boolean union(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {

                if (rank[rootX] > rank[rootX])
                    root[rootY] = rootX;
                else if (rank[rootX] < rank[rootX])
                    root[rootX] = rootY;
                else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            } else {
                return false;
            }

            return true;
        }
    }
}
