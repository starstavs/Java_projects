package milionare;


public class Question extends Questions {
    private String questionName;
    private int questionScore;


    Question(int questionLevel, int questionNumber, String questionName) {
        super(questionLevel, questionNumber);
        this.questionName = questionName;
    }

    public String getQuestionName() {
        return questionName;
    }




    @Override
    public String toString() {
        return super.toString() + questionName;
    }
}
