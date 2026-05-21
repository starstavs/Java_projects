package milionare;

public abstract class Questions {
    private int questionLevel;
    private String questionLevelName;
    private int questionNumber;

    Questions(int questionLevel, int questionNumber, String questionLevelName) {
        this.questionLevel = questionLevel;
        this.questionNumber = questionNumber;
        this.questionLevelName = questionLevelName;
    }
}
