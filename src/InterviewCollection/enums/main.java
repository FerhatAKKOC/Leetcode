package InterviewCollection.enums;

public class main {

    public static void main(String[] args) {

        var t = Season.valueOf("SUMMER");
        System.out.println(t + " " + t.ordinal() + " " + t.getValue() + " " + t.name());

        for (var e : Season.values())
            System.out.println(e + " " + e.ordinal() + "  " + e.getValue());


    }
}
