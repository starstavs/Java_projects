package milionare;

public abstract class Questions {
    private int questionLevel;
    private int questionNumber;

    Questions(int questionLevel, int questionNumber) {
        this.questionLevel = questionLevel;
        this.questionNumber = questionNumber;

    }

    public int getQuestionLevel() {
        return questionLevel;
    }

    public int getQuestionNumber(){
        return questionNumber;
    }

    @Override
    public String toString(){

        return "Level " + questionLevel + " question Nr. " + questionNumber;
    }
}
