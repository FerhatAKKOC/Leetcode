package InterviewCollection.BinarySearch;

public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {

        char[] letters = {'a', 'b', 'c', 'f', 'j'};
        char target = 'j';

//        System.out.println("Output : " + findCharacterIndex(letters, target));

    }


    public char nextGreatestLetter(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }

    //*********************************************************************************
    // Kendi çözümüm
    private static char nextGreatestLetter2(char[] letters, char target) {

        int n = letters.length - 1;

        if (((int) target) > (int) letters[n]) // target exceeds array [a,b,c]   target : d
            return letters[0];
        if (((int) target) < (int) letters[n]) // target exceeds array [d,e,f ]   target : a
            return letters[0];

        return ' ';
    }

    private static int findCharacterIndex(char[] letters, char target) {

        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (letters[mid] == target)
                return mid;
            else if (letters[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
