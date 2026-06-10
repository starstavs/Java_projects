package help;

import milionare.Answer;

public class PhoneHelp extends HelpOption {
    private int[] probabilityOfCorrectAnswer = new int[4];
    private int overallPercentage;

    public PhoneHelp(boolean isUsed) {
        super(isUsed, HelpType.PHONE_HELP.getHelpOptionName());
    }

    @Override
    public int[] getHelp(Answer answer, int correctAnswer) {
        if (getIsUsed()) {
            System.out.println("You have already used this hint.");
            return new int[0];
        }
        setIsUsed(true);
        correctAnswer--;

        probabilityOfCorrectAnswer[correctAnswer] = getRandomNumber(20) + 50;
        overallPercentage = 100 - probabilityOfCorrectAnswer[correctAnswer];
        for (int i = 0; i < answer.getAnswer().length; i++) {
            if (i == correctAnswer) continue;
            else if (i == answer.getAnswer().length - 1) {
                probabilityOfCorrectAnswer[i] = overallPercentage;
            } else {
                probabilityOfCorrectAnswer[i] = getRandomNumber(overallPercentage);
                overallPercentage -= probabilityOfCorrectAnswer[i];
            }

        }


        return probabilityOfCorrectAnswer;
    }

}
