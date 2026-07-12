package help;

import millionaire.Answer;
import millionaire.Question;

import java.util.*;

public class FiftyFiftyHelp extends HelpOption {

    private List<Answer> wrongAnswer = new ArrayList<>();
    private int randomNumber;
    private int correctAnswer;
    // private Random random = new Random();

    public FiftyFiftyHelp(boolean isUsed) {
        super(isUsed, HelpType.FIFTY_FIFTY_HELP.getHelpOptionName());
    }


    public List<Answer> getHelp(Question question) {
        if (getIsUsed()) {
            return Collections.emptyList();
        }
        setIsUsed(true);
        wrongAnswer.addAll(Arrays.asList(question.getAnswers()));
        wrongAnswer.removeIf(answer -> answer.isCorrect());
        Collections.shuffle(wrongAnswer);
        wrongAnswer.remove(0);
        wrongAnswer.forEach(answer -> answer.setIsVisible(false));
        return wrongAnswer;
    }

   /* private int getRandomNumber(int numberOfAnswer) {
        randomNumber = random.nextInt(numberOfAnswer);

        return randomNumber;
    }*/

//    private boolean ifExist(int randomNumber) {
//        for (int j : wrongAnswer) {
//            if (j == randomNumber) return true;
//        }
//        return false;
//    }

}

