package InterviewCollection.QueueStack;

import java.util.*;

public class OpenTheLock {

    public static void main(String[] args) {

        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        System.out.println("Output : " + openLock(deadends,target));


    }

    public static int openLock(String[] deadends, String target) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        int depth = -1;

        queue.add("0000");

        while (!queue.isEmpty()) {

            depth++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String node = queue.poll();

                if (node.equals(target))
                    return depth;
                if (visited.contains(node))
                    continue;

                visited.add(node);

                queue.addAll(getSuccessors(node));
            }
        }


        return -1;
    }


    private static List<String> getSuccessors(String str) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 : str.charAt(i) - '0' - 1) + str.substring(i + 1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 : str.charAt(i) - '0' + 1) + str.substring(i + 1));
        }
        return res;
    }

    //*********************************************************************
    //*********************************************************************
    private static String[] generateChildren(String str) {


        List<String> list = new ArrayList<>();
        StringBuilder sb;

        for (int i = 0; i < str.length(); i++) {

            sb = new StringBuilder(str);
            char c = sb.charAt(i);

            // -1
            if (c == '0') sb.setCharAt(i, '9');      // 0 -> 9
            else sb.setCharAt(i, (char) ((int) c - 1)); //  3 -> 2
            list.add(sb.toString());

            sb = new StringBuilder(str);

            // +1
            if (c == '9') sb.setCharAt(i, '0');     // 9 -> 0
            else sb.setCharAt(i, (char) ((int) c + 1)); // 3 -> 4
            list.add(sb.toString());
        }

        return list.toArray(new String[list.size()]);
    }
}
