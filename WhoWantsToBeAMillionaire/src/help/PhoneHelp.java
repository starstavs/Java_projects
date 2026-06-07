package help;

import milionare.Answer;

public class PhoneHelp extends HelpOption {
    private int[] probabilityOfCorrectAnswer = new int[4];

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

        

        return new int[0];
    }

}
