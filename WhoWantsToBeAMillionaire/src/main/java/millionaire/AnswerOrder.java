package millionaire;

public enum AnswerOrder {
    LETTER_1(1, "A"),
    LETTER_2(2, "B"),
    LETTER_3(3, "C"),
    LETTER_4(4, "D");

    private final int orderNumber;
    private final String orderLetter;

    AnswerOrder(int orderNumber, String orderLetter) {
        this.orderNumber = orderNumber;
        this.orderLetter = orderLetter;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getOrderLetter() {
        return orderLetter;
    }
}
