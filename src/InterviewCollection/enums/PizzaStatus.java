package InterviewCollection.enums;

public enum PizzaStatus {
    ORDERED(3),
    READY(4),
    DELIVERED(5);

    private int status;

    PizzaStatus(int status) {
        this.status = status;
    }
}
