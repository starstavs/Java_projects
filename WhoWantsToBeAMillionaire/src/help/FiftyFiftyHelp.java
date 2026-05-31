package help;

import milionare.Answer;

public class FiftyFiftyHelp extends HelpOption {


    public FiftyFiftyHelp(boolean isUsed) {
        super(isUsed, HelpType.FIFTY_FIFTY_HELP.getHelpOptionName());
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

