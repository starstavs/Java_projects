package edu.tekwill.millionaire.help;

import millionaire.Answer;

import java.util.Random;

public abstract class HelpOption {


    private boolean isUsed = false;
    private Answer answer;
    private final String helpOptionName;
    private int randomNumber;
    private Random random = new Random();

    HelpOption(boolean isUsed, String helpOptionName) {
        this.isUsed = isUsed;
        this.helpOptionName = helpOptionName;

    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public Answer getAnswer() {
        return answer;
    }


    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }


    public int getRandomNumber(int randomizeNumber) {
        randomNumber = random.nextInt(randomizeNumber);

        return randomNumber;
    }

    @Override
    public String toString() {
        if (isUsed) return "\u001B[9m" + helpOptionName + "\u001B[0m";
        return helpOptionName;
    }
}
