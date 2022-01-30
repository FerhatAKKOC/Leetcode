package InterviewCollection.CollectionsHard;

public class trappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Output: " + trap(height));
    }

    /*
        Trapping Rain Water
        https://www.youtube.com/watch?v=ZI2z5pq0TqA
     */
    private static int trap(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];

        int result = 0;

        while (l < r) {
                                        // en sağ ve en soldaki indexlerde hiç bir zaman su birikmez. Her zaman oralar sıfır geldiğinden direk shift işlemine geçiyoruz
            if (leftMax < rightMax) {   // küçük olanu shift edeceğiz, eşitse önemli değil ne taraftan shift edeceğimiz
                l++;
                leftMax = Math.max(leftMax, height[l]);
                result += leftMax-height[l];  // Min(LeftMax, rightMax) 'e gerek yok. Çünkü her zaman min tarafı shift ediyoruz. zaten ihtiyacımızda min değeri.
            }else {
                r--;
                rightMax = Math.max(rightMax,height[r]);
                result += rightMax-height[r];
            }
        }
        return result;
    }
}
