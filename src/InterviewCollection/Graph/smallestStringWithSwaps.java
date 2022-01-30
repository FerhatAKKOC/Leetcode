package InterviewCollection.Graph;

import java.util.*;

public class smallestStringWithSwaps {

    public static void main(String[] args) {
        String s = "dcab";

        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 2));

        System.out.println("Output: " + smallestStringWithSwaps(s, pairs));
    }

    /*
        Smallest String With Swaps
     */
    static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length();
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (var pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).offer(sChar[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sChar.length; i++) {
            sb.append(map.get(find(i)).poll());
        }
        return sb.toString();
    }

    //*********************************

    static int[] root;

    static int find(int x) {
        if (x == root[x])
            return x;
        return root[x] = find(root[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX < rootY) {
            root[rootY] = rootX;
        } else {
            root[rootX] = rootY;
        }
    }

    /*
        Açıklama:
        Input: s = "cba", pairs = [[0,1],[1,2]]
        Mesala bu örnekte bütün karakterlerden sadece bir grup oluşturulur. Çünkü 2 karakterde (0,1) ve (1,2) ile birbirine bağlıdır ve istediğimiz kombinasyonu alabiliriz.
        O zaman bu gruptan en küçük karakteri seçeriz, 'a'. Geriye ne kaldı 'cb'. Oradan da en küçük karakteri seçebiliriz. 'b'. ve sonra 'c'. Burada istediğimiz karakteri seçebilmemizin nedeni
        hepsinin tek bir grup olması.

        Input: s = "dcab", pairs = [[0,3],[1,2]]
        Bu örnekte 2 farklı grup vardır.Çünkü pairs'lere baktığımızda bütün karakterler, graph üzerinde birbirine bağlı değişdir. cb ve db ayrı 2 grup oluşturur.
        O zaman ilk önce 'd' karakterinin bağlı olduğu grubu buluruz (db grubu). O gruptaki en küçük karakteri seçeriz,'b'. Bunun seçebilmemizin nedeni, b,r grup içerisinde istediğimiz kadar
        swap operasyonu yaparak istediğimiz karakteri elde edebilme imkanımız.
        2. karakter nedir, 'c'. c'nin bağlı olduğu grup ise ca grubudur. bu gruptaki en küçük karakter ise 'a' dır.

        Bu şekilde devam ederiz. Gruptaki karakterler bir tabe PriorityQueue içerisine konarak, kullandıkça bir karakteri o gruptan silmemizi sağlıyor. Ayrıca pq bize ne küçük karakteri dönüyor.
     */
}
