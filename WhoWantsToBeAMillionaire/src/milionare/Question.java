package milionare;


public class Question extends Questions {
    private String questionName;
    private int questionScore;

    Question(int questionLevel, int questionNumber, String questionName, int questionScore) {
        super(questionLevel, questionNumber);
        this.questionName = questionName;
        this.questionScore = questionScore;
    }
}
