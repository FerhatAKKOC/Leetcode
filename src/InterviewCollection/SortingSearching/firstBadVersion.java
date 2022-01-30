package InterviewCollection.SortingSearching;

public class firstBadVersion {

    public static void main(String[] args) {


        System.out.println("Bad Version: " + firstBadVersion(17));
    }

    /*
        You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
        Since each version is developed based on the previous version, all the versions after a bad version are also bad.

        Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

        You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
     */


    private static int firstBadVersion(int n) {

        int start=1;
        int end = n;
        int bad = 3;

        while (end>start){

            int mid = (start + end)/2;

            if(mid == bad)
                return bad;
            else if(mid>bad){
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return  start;
    }
}
