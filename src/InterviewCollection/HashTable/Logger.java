package InterviewCollection.HashTable;

import java.util.HashMap;

public class Logger {

    HashMap<String, Integer> map;

    public Logger() {
        this.map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if (map.containsKey(message)) {

            if ((timestamp - map.get(message)) >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}
