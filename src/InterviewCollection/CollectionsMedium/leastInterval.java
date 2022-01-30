package InterviewCollection.CollectionsMedium;

import java.util.*;

public class leastInterval {

    public static void main(String[] args) {

        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int n = 2;

        System.out.println("Output: " + leastInterval(tasks, n));
    }

    private static int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);


        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq.addAll(map.values());

        int alltime = 0;

        while (!pq.isEmpty()) {

            int worktime = 0;
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i <= n; i++) { // her n+1 aralıklı pencereye, aynı harfli task'lar koyamıyoruz.
                if (!pq.isEmpty()) {
                    tmp.add(pq.poll());  // dolayısıyla sürekli poll ediyoruz. Her poll'da farklı bir karakterin sayısı geliyor.
                    worktime++;
                }
            }

            for (int cnt : tmp) {
                if (--cnt > 0) { // pq'dan çekilen değerleri bir azaltıp tekrardan pq'ya ekliyoruz.
                    pq.offer(cnt);
                }
            }                                               // mesala n=2 ise A-B-C-A-B ... dikkat edersek (n+1) lik bir iş var her pencerede. Üstelik A -> idle -> idle -> A -> idle -> idle gibi birşeyide garanti ediyor.
            alltime += !pq.isEmpty() ? (n + 1) : worktime; // pq'da değer varsa biz en az n+1 bir pencere doldurmamız lazım. worktime is en son pencere dolmaz zorunda değil.
        }

        return alltime;
    }
}
