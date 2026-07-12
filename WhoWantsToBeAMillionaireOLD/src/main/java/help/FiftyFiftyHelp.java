package help;

import millionaire.Answer;

public class FiftyFiftyHelp extends HelpOption {

    private int[] wrongAnswer = new int[2];
    private int randomNumber;
   // private Random random = new Random();

    public FiftyFiftyHelp(boolean isUsed) {
        super(isUsed, HelpType.FIFTY_FIFTY_HELP.getHelpOptionName());
    }


    @Override
    public int[] getHelp(Answer answer, int correctAnswer) {
        if (getIsUsed()) {
            return new int[0];
        }
        correctAnswer--;
        setIsUsed(true);


        wrongAnswer[0] = (answer.getAnswer().length) + 1;
        wrongAnswer[1] = (answer.getAnswer().length) + 1;

        for (int i = 0; i < 2; i++) {
            do {
                randomNumber = getRandomNumber(answer.getAnswer().length);

            } while (randomNumber == correctAnswer || ifExist(randomNumber));
            wrongAnswer[i] = randomNumber;
            // System.out.println(wrongAnswer[i]);
        }
        return wrongAnswer;
    }

   /* private int getRandomNumber(int numberOfAnswer) {
        randomNumber = random.nextInt(numberOfAnswer);

        return randomNumber;
    }*/

    private boolean ifExist(int randomNumber) {
        for (int j : wrongAnswer) {
            if (j == randomNumber) return true;
        }
        return false;
    }

}

