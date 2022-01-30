package InterviewCollection.Amazon;

import java.util.Arrays;

public class compareVersion {

    public static void main(String[] args) {
        String version1 = "7.5.2.4", version2 = "7.5.3";
//        String version1 = "1.01", version2 = "1.001";
//        String version1 = "1.0", version2 = "1.0.0";
//        String version1 = "0.1", version2 = "1.1";
//        String version1 = "1.0.1", version2 = "1";

        System.out.println("Output: " + compareVersion(version1, version2));
    }


    private static int compareVersion(String version1, String version2) {

        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {

            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;

            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }

        // the versions are equal
        return 0;
    }
    /*
        Time complexity : \mathcal{O}(N + M + max(N, M)) O(N+M+max(N,M)), where N and M are lengths of input strings.
        Space complexity : \mathcal{O}(N + M)O(N+M) to store arrays nums1 and nums2.
     */
}
