package InterviewCollection.company.Wireless;

public class APICaller {

    static int[] tempDays = {14, 4, 5, 3, 16, 14};

    public int getNumDays() {

        return tempDays.length;
    }

    public int getTemperatureOnDay(int day) {

        return tempDays[day];
    }
}
