package millionaire;


import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String questionName;
    private final int questionScore;
    private final int questionLevel;
    private final int questionNumber;
    private Answer[] answers;
    private Answer[] wrongAnswer = new Answer[4];


   public Question(int questionLevel, int questionNumber, String questionName, Answer[] answers, int questionScore) {
        this.questionLevel = questionLevel;
        this.questionNumber = questionNumber;
        this.questionName = questionName;
        this.answers = answers;
        this.questionScore = questionScore;

    }

    public String getQuestionName() {

        return questionName;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public int getQuestionScore() {
        return questionScore;
    }

    public int getQuestionLevel() {
        return questionLevel;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }


    public boolean getCorrectAnswer(int selectedAnswer) {

        return answers[selectedAnswer].isCorrect();
    }

    public int getCorrectAnswerIndex() {
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].isCorrect()) {
                return i;
            }
        }
        return -1;
    }
//    public Answer[] getWrongAnswer() {
//        wrongAnswer =
//        return wrongAnswer;
//    }


    @Override
    public String toString() {
        return super.toString() + questionName;
    }
}
