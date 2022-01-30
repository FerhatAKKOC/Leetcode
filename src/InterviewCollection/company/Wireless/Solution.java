package InterviewCollection.company.Wireless;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution implements SolutionInterface {

    public static void main(String[] args) {
        Solution test = new Solution(new APICaller());
    }

    private APICaller api;
    static int startDay = 0;
    static int endDay = 0;

    public Solution(APICaller api) {
        api = new APICaller();

        int totalDays = api.getNumDays();
        int longestConDays = 0;

        for (int i = 0; i < totalDays; i++) {

            int start = i, end = i;

            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = i; j < totalDays; j++) {

                min.offer(api.getTemperatureOnDay(j));  // to keep min degree
                max.offer(api.getTemperatureOnDay(j));  // to keep max degree

                if (Math.abs(min.peek() - max.peek()) <= 5) {
                    //System.out.println("start: " + start + "  end : " + end);
                    end = j;
                } else {
                    break;
                }

                if (min.size() > 1) min.poll();
                if (max.size() > 1) max.poll();
            }

            if ((end - start + 1) > longestConDays) {
                longestConDays = end - start + 1;
                startDay = start;
                endDay = end;
                //System.out.println("longestConDays: " + longestConDays + "\tstartDay: " + startDay + "\tendDay : " + endDay);
            }
        }

        System.out.println("-----------Result---------------");
        System.out.println("longestConDays: " + longestConDays + "\tstartDay: " + startDay + "\tendDay : " + endDay);

    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }
}
