package help;

import milionare.Answer;

public class AudienceHelp extends HelpOption {

    public AudienceHelp(boolean isUsed) {
        super(isUsed, HelpType.AUDIENCE_HELP.getHelpOptionName());
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
