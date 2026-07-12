package edu.tekwill.millionaire.help;

import edu.tekwill.millionaire.model.Answer;
import edu.tekwill.millionaire.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FiftyFiftyHelp extends HelpOption {

    private List<Answer> wrongAnswer = new ArrayList<>();
    private int randomNumber;
    private int correctAnswer;

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
}

