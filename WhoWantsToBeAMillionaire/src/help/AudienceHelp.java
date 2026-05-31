package help;

import milionare.Answer;

public class AudienceHelp extends HelpOption {

    public AudienceHelp(boolean isUsed) {
        super(isUsed, HelpType.AUDIENCE_HELP.getHelpOptionName());
    }

    @Override
    public void getHelp(Answer answer) {
        if (getIsUsed()) {
            System.out.println("You have already used this hint.");
            return;
        }
        setIsUsed(true);
    }
}
