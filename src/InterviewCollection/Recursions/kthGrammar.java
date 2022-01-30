package InterviewCollection.Recursions;

public class kthGrammar {
    public static void main(String[] args) {


        System.out.println(kthGrammar(3,1));
    }

    /*
        We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

        For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
        Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
     */
    private static int kthGrammar(int n, int k) {
        var result = helper(n);
        return  Integer.parseInt(String.valueOf(result.charAt(k-1)));
    }

    private static String helper(int n) {
        if (n < 2) return "0";
        var result =  helper(n-1);

        StringBuilder temp = new StringBuilder();
        for(char c : result.toCharArray()){
            if(c == '1') temp.append("10");
            if(c == '0') temp.append("01");
        }
        return temp.toString();
    }
}





































