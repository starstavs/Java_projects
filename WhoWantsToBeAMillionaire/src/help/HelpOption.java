package help;

import milionare.Answer;

public abstract class HelpOption {


    private boolean isUsed = false;
    private Answer answer;
    private int correctAnswer;
    private final String helpOptionName;

    HelpOption(boolean isUsed, String helpOptionName) {
        this.isUsed = isUsed;
        this.helpOptionName = helpOptionName;

    }

    public String getHelpOptionName() {
        return helpOptionName;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public Answer getAnswer() {
        return answer;
    }

    public abstract void getHelp(Answer answer);

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    @Override
    public String toString() {
        if (isUsed) return "\u001B[9m" + helpOptionName + "\u001B[0m";
        return helpOptionName;
    }
}
