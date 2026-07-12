package question;

public class Answer {


    private String answer;
    private boolean isCorrect;
    private AnswerOrder answerOrder;
    private boolean isVisible;

    public Answer(String answer, boolean isCorrect,   AnswerOrder answerOrder) {

        this.answer = answer;
        this.isCorrect = isCorrect;
        this.answerOrder = answerOrder;
        this.isVisible = true;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public AnswerOrder getAnswerOrder() {
        return answerOrder;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public  void setIsVisible(boolean isVisible){
        this.isVisible = isVisible;
    }
}
