package milionare;

public class Answer extends Questions {

    //private int[] answerIndex = {1, 2, 3, 4};
    private String[] answer = new String[4];
    private int correctAnswer;

    Answer(int questionLevel, int questionNumber, String answer1, String answer2, String answer3, String answer4, int correctAnswer) {
        super(questionLevel, questionNumber);
        answer[0] = answer1;
        answer[1] = answer2;
        answer[2] = answer3;
        answer[3] = answer4;
        this.correctAnswer = correctAnswer;
    }

    public String[] getAnswer() {
        return answer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }



    @Override
    public String toString() {
        return super.toString() + answer[0] + ", " + answer[1] + ", " + answer[2] + ", " + answer[3] + ", " + correctAnswer;
    }
}


