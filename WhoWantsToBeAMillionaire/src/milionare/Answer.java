package milionare;

public class Answer extends Questions {

    //private int[] answerIndex = {1, 2, 3, 4};
    private String[] answer = new String[4];
    private int correctAnswer;

    Answer(int questionLevel, int questionNumber, int correctAnswer, String answer1, String answer2, String answer3, String answer4) {
        super(questionLevel, questionNumber);
        answer[0] = answer1;
        answer[1] = answer2;
        answer[2] = answer3;
        answer[3] = answer4;
        this.correctAnswer = --correctAnswer;
    }
}


