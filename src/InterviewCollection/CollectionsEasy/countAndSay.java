package InterviewCollection.CollectionsEasy;

public class countAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }


    private static String countAndSay(int n) {

        if (n == 2) return "11";

        var res = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();

        int count = 1;

        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i - 1) == res.charAt(i)) {
                count++;
            } else {
                sb.append(count).append(res.charAt(i - 1));
                count = 1;
            }
        }

        sb.append(count).append(res.charAt(res.length() - 1));

//        System.out.println(sb.toString());
        return sb.toString();

    }


}
