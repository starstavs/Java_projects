package milionare;


public class Question extends Questions {
    private String questionName;
    private int questionScore;

    Question(int questionLevel, int questionNumber, String questionLevelName, String questionName, int questionScore) {
        super(questionLevel, questionNumber,questionLevelName);
        this.questionName = questionName;
        this.questionScore = questionScore;
    }
}
