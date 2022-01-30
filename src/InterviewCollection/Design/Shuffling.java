package InterviewCollection.Design;

import java.util.Random;

public class Shuffling {


    public static void main(String[] args) {

    }


    class Solution {

        int[] array;
        int[] data;

        private Random random = new Random();

        private int getRandom(int min, int max) {
            return random.nextInt(max - min) + min;
        }

        private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public Solution(int[] nums) {
            this.array = nums;
            this.data = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            this.array = this.data;
            this.data = this.data.clone();
            return this.array;
        }

        /**
         * Fisher-Yates Algorithm. Time complexity: O(n) ,  Space complexity: O(n)
         */
        public int[] shuffle() {
            for (int i = 0; i < array.length; i++) {
                swap(i, getRandom(i, array.length));
            }
            return array;
        }
    }
}
