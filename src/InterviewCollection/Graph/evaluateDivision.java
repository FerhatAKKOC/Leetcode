package InterviewCollection.Graph;

import java.awt.font.FontRenderContext;
import java.util.*;

public class evaluateDivision {

    public static void main(String[] args) {

    }

    /*
        Evaluate Division
        https://www.youtube.com/watch?v=UcDZM6Ap5P4
     */
    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {


        Map<String, List<Node>> graph = buildGraph(equations, values);

        double[] result = new double[values.length];

        for (int i = 0; i < queries.size(); i++) {
            var src = queries.get(i).get(0);    // "a"
            var dest = queries.get(i).get(1);   // "c"
            result[i] = dfs(src, dest, new HashSet<>(), graph);
        }

        return result;
    }

    private double dfs(String src, String dest, HashSet<String> visited, Map<String, List<Node>> graph) {

        if (!(graph.containsKey(src) && graph.containsKey(dest))) // one character is missing in graph
            return -1.0;  // farklı bir yoldan gider, asıl dest ulaşamazsakta -1 dönülecektir.

        if (src.equals(dest))
            return 1.0;

        visited.add(src);

        for (var ng : graph.get(src)) {
            if (!visited.contains(ng.dest)) {
                var ans = dfs(ng.dest, dest, visited, graph);
                if(ans != -1.0)
                    return ans* ng.weight;
            }
        }

        return -1;
    }

    private Map<String, List<Node>> buildGraph(List<List<String>> eq, double[] values) {

        Map<String, List<Node>> map = new HashMap<>();    // "a"->"b" ve "a"->"f", "a"->"t" ve ağırlık bilgilerini her bir node için tutacaktır.

        for (int i = 0; i < values.length; i++) {

            var pairs = eq.get(i);  // ["a","b"]
            var src = pairs.get(0);     // "a"
            var dest = pairs.get(1);    // "b"
            var val = values[i];        // 2.0

            map.putIfAbsent(src, new ArrayList<>());    // "a" -> "b" ise weight:2.0
            map.get(src).add(new Node(dest, val));

            map.putIfAbsent(dest, new ArrayList<>());  // "b"->"a" ise 1/2.0 ters yönde gidersek 1/val olur.
            map.get(dest).add(new Node(src, 1 / val));
        }

        return map;
    }

    class Node {     // "a" -> "b" için bu node, 'b' ve 2.0 bilgisini kaydedecek.ç "a"->"f"  için başka bir bilgi kaydedecek
        String dest;
        double weight;

        public Node(String dest, double weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
