package help;

import milionare.Answer;

public class PhoneHelp extends HelpOption {

    public PhoneHelp(boolean isUsed) {
        super(isUsed, HelpType.PHONE_HELP.getHelpOptionName());
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
