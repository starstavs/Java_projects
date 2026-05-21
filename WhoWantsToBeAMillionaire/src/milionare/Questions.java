package milionare;

public abstract class Questions {
    private int questionLevel;
    private int questionNumber;

    Questions(int questionLevel, int questionNumber) {
        this.questionLevel = questionLevel;
        this.questionNumber = questionNumber;
    }
}
