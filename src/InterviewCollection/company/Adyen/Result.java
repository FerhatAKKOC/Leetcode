package InterviewCollection.company.Adyen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Result {

    /**
     * An entity to hold bin range details. A bin range is a pair of 12 digit numbers that
     * mark the boundaries of the range which is maped to other bin range properties such
     * as a card type. The range boundaries are inclusive.
     */
    static final class BinRange {
        final String start;
        final String end;
        final String cardType;

        BinRange(String start, String end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }
    }


    //  I need a hashmap which hold index and CardType. Each index corresponding an interval (start-end).
    private static HashMap<Integer, String> cache = new HashMap<>();
    private static List<Long> startEndList = new ArrayList<>();

    interface CardTypeCache {
        /**
         * @param cardNumber 12 to 23 digit card number.
         * @return the card type for this cardNumber or null if the card number does not
         * fall into any valid bin ranges.
         */
        String get(String cardNumber);
    }

    /**
     * @param binRanges the list of card bin ranges to build a cache from.
     * @return an implementation of CardTypeCache.
     */
    public static CardTypeCache buildCache(List<BinRange> binRanges) {

        cache = new HashMap<>();

        for (int i = 0; i < binRanges.size(); i++) {
            cache.put(i, binRanges.get(i).cardType);
        }

        for (BinRange binRange : binRanges) {
            startEndList.add(Long.valueOf(binRange.start)); // Previously, Integer type used, I converted it to 'Long' type
            startEndList.add(Long.valueOf(binRange.end));
        }

        return new CardTypeCacheImpl();
    }

    static class CardTypeCacheImpl implements CardTypeCache {


        public String get(String cardNumber) {

            //Integer index = findIndexLinear(Long.valueOf(cardNumber));    // Linear Search
            Integer index = findIndexBinary(Long.valueOf(cardNumber));      // Binary Search
            return (index != -1) ? cache.get(index) : "null";
        }

        /**
         * Linear Search O(n)
         *
         * @param cardNumber, Searching an index which is between start-end .
         * @return an index. If not found, return -1.
         */
        private Integer findIndexLinear(Long cardNumber) {

            for (int i = 1; i < startEndList.size(); i += 2) {
                if (startEndList.get(i - 1) <= cardNumber && cardNumber <= startEndList.get(i)) {
                    return i / 2;
                }
            }
            return -1;
        }

        /**
         * Binary Search O(logn)
         *
         * @param cardNumber, Searching an index which is between start-end .
         * @return an index. If not found, return -1.
         */
        private Integer findIndexBinary(Long cardNumber) {

            int left = 0;
            int right = startEndList.size();

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (mid % 2 == 0 && startEndList.get(mid) <= cardNumber && cardNumber <= startEndList.get(mid + 1)) { // right pair (start-end) of mid
                    return mid / 2;
                } else if (mid % 2 == 1 && startEndList.get(mid - 1) <= cardNumber && cardNumber <= startEndList.get(mid)) {  // left pair
                    return mid / 2;
                }

                if (cardNumber < startEndList.get(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
