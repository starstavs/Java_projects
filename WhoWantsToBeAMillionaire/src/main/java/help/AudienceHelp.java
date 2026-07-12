package help;


import question.Question;


public class AudienceHelp extends HelpOption {
    private int[] probabilityOfCorrectAnswer = new int[4];
    private int overallPercentage;
    private int correctAnswer;


    public AudienceHelp(boolean isUsed) {

        super(isUsed, HelpType.AUDIENCE_HELP.getHelpOptionName());
    }


    public int[] getHelp(Question question) {
        if (getIsUsed()) {
            System.out.println("You have already used this hint.");
            return new int[0];
        }
        setIsUsed(true);
        correctAnswer = question.getCorrectAnswerIndex();

        probabilityOfCorrectAnswer[correctAnswer] = getRandomNumber(20) + 50;
        overallPercentage = 100 - probabilityOfCorrectAnswer[correctAnswer];
        for (int i = 0; i < question.getAnswers().length; i++) {
            if (i == correctAnswer) continue;
            else if (!question.getAnswers()[i].isVisible()) continue;
            else if (i == question.getAnswers().length - 1) {
                probabilityOfCorrectAnswer[i] = overallPercentage;
            } else {
                probabilityOfCorrectAnswer[i] = getRandomNumber(overallPercentage);
                overallPercentage -= probabilityOfCorrectAnswer[i];
            }

        }

        return probabilityOfCorrectAnswer;
    }


}
