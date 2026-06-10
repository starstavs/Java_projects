package milionare;

import help.AudienceHelp;
import help.FiftyFiftyHelp;
import help.HelpType;
import help.PhoneHelp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;


public class WhoWantsToBeAMillionaire {
    static Scanner scan = new Scanner(System.in);                               //Scanner value
    static String playerName;                                                   //Player name
   // static Question[] question = new Question[60];                              //Array with questions
    static List<Question> question = new ArrayList<>();
    //static Answer[] answers = new Answer[240];                                  //Array with answers
    static List<Answer> answers = new ArrayList<>();
    static String[] currentAnswer = new String[4];                              //Array with 4 available answer for question
    static FiftyFiftyHelp fiftyFiftyHelp = new FiftyFiftyHelp(false);    //Help 50/50
    static AudienceHelp audienceHelp = new AudienceHelp(false);          //Help audience
    static PhoneHelp phoneHelp = new PhoneHelp(false);                   //Help phone
    static int questionIndex = 0, answerIndex = 0;                              //Number of questions and answers
    static boolean action;                                                      //Game is active
    static int levelGame = 0;                                                   //Selected level
    static String option;                                                       //User's Choice
    static int[] questionNumberInLevel = new int[300];                           //Number of possible questions in a level
    static int questionInLevel;                                             //Current number of questions in the level
    static int selectedIndexQuestion;                                           //Selected index of question
    static Question selectedQuestion;                                           //Selected question
    static Random random = new Random();                                        //Random question from all the questions
    static final int[] guaranteedAmountArray = {1000, 100000, 1000000};
    static final String[] answerLetter = {"A)", "B)", "C)", "D)"};//Guaranteed amount array
    static int guaranteedAmount = 0;                                            //Guaranteed amount earned
    static int currentAmount = 0;                                               //Current amount earned
    static boolean isCorrect;                                                   //If answer is correct
    static int[] wrongNumbers = new int[2];
    static boolean isAnswered;
    static String gameState;
    static boolean ifExistWrongAnswer;
    static int[] probabilityOfCorrectAnswer;
    static int[] probabilityFriendCorrectAnswer;


    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Welcome to the game \"Who wants to be a millionaire\" ");
        System.out.println("What is your name?");
        playerName = scan.nextLine();
        System.out.println("Hallo " + playerName + ". I will explain the rules of the game to you.");
        gameRules();
        action = scan.nextLine().equalsIgnoreCase("Y");
        setQuestions();
        //displayQuestions();
        while (action) {
            levelGame++;
            isAnswered = false;
            gameState = HelpType.NONE.getHelpOptionName();

            displayQuestion();

            while (!isAnswered) {
                displayAnswer();
                displayHelp();
                getUserResponse();
            }
            if (!isCorrect) {
                textOutput("Unfortunately, you gave the wrong answer.");
                //textOutput("The correct answer is " + currentAnswer[(int) (answers[selectedIndexQuestion].getCorrectAnswer() - 1)]);
                textOutput("The correct answer is " + currentAnswer[(int) (answers.get(selectedIndexQuestion).getCorrectAnswer() - 1)]);

                textOutput(" You earned " + guaranteedAmount + " lei on this game.");
                textOutput("Game is over");
                action = false;
            }
            if (levelGame == Levels.getLevelLength() || guaranteedAmount == guaranteedAmountArray[2]) {
                textOutput("Congratulations, " + playerName + "! You won our game and earned " + guaranteedAmount + " lei.");
                action = false;
            }

        }
    }

    private static void getUserResponse() {
        while (true) {
            option = scan.nextLine();
            switch (option.toLowerCase()) {
                case "a" -> isCorrect = checkAnswer(1);
                case "b" -> isCorrect = checkAnswer(2);
                case "c" -> isCorrect = checkAnswer(3);
                case "d" -> isCorrect = checkAnswer(4);
                case "f" -> {
                    gameState = HelpType.FIFTY_FIFTY_HELP.getHelpOptionName();
                    //wrongNumbers = fiftyFiftyHelp.getHelp(answers[selectedIndexQuestion], answers[selectedIndexQuestion].getCorrectAnswer());
                    wrongNumbers = fiftyFiftyHelp.getHelp(answers.get(selectedIndexQuestion), answers.get(selectedIndexQuestion).getCorrectAnswer());
                    if (wrongNumbers.length == 0) {
                        System.out.println("You have already used this hint.");
                        continue;
                    }

                    break;
                }
                case "p" -> {
                    gameState = HelpType.PHONE_HELP.getHelpOptionName();
                   // probabilityFriendCorrectAnswer = phoneHelp.getHelp(answers[selectedIndexQuestion], answers[selectedIndexQuestion].getCorrectAnswer());
                    probabilityFriendCorrectAnswer = phoneHelp.getHelp(answers.get(selectedIndexQuestion), answers.get(selectedIndexQuestion).getCorrectAnswer());
                    if (probabilityFriendCorrectAnswer.length == 0) {
                        System.out.println("You have already used this hint.hhhhg");
                        continue;
                    }

                    break;
                }
                case "s" -> {
                    gameState = HelpType.AUDIENCE_HELP.getHelpOptionName();
                    //probabilityOfCorrectAnswer = audienceHelp.getHelp(answers[selectedIndexQuestion], answers[selectedIndexQuestion].getCorrectAnswer());
                    probabilityOfCorrectAnswer = audienceHelp.getHelp(answers.get(selectedIndexQuestion), answers.get(selectedIndexQuestion).getCorrectAnswer());
                    if (probabilityOfCorrectAnswer.length == 0) {
                        System.out.println("You have already used this hint.");
                        continue;
                    }

                    break;
                }

                default -> {
                    textOutput("You pressed the wrong button out of nervousness. :)");
                    textOutput("Come on, let's try one more time.");
                    continue;
                }

            }
            break;
        }
    }

    private static boolean checkAnswer(int selectedAnswer) {
        isAnswered = true;
        //if (selectedAnswer == answers[selectedIndexQuestion].getCorrectAnswer()) {
        if (selectedAnswer == answers.get(selectedIndexQuestion).getCorrectAnswer()) {
            textOutput("Congratulations! That is the correct answer.");
            currentAmount = Levels.getLevelBonusByNumber(levelGame);
            textOutput("You earned " + currentAmount + " lei for the correct answer to the question.");
            for (int sum : guaranteedAmountArray) {
                if (currentAmount == sum) {
                    guaranteedAmount = currentAmount;
                    textOutput("You have reached your guaranteed amount and it is " + guaranteedAmount + " lei.");
                    break;
                }
            }
            return true;

        } else {
            // System.out.println("Oblom");
            return false;
        }
    }

    private static void displayQuestion() {
        System.out.println("\n");
        textOutput("Question from the section \"" + Levels.getLevelDescriptionByNumber(levelGame) + "\"");
        textOutput("The cost of the question is " + Levels.getLevelBonusByNumber(levelGame) + " lei.");
        System.out.println("\n");

        selectedQuestion = getQuestionByLevel(levelGame);
        textOutput(selectedQuestion.getQuestionName());

    }

    private static void displayAnswer() {
        displayAnswerOptions(selectedIndexQuestion);
    }

    private static void displayHelp() {
        textOutput("------Help------");
        textOutput(fiftyFiftyHelp + " | " + phoneHelp + " | " + audienceHelp);
    }

    private static void displayAnswerOptions(int selectedIndexQuestion) {
        //currentAnswer = answers[selectedIndexQuestion].getAnswer();
        currentAnswer = answers.get(selectedIndexQuestion).getAnswer();

        if (gameState.equals(HelpType.AUDIENCE_HELP.getHelpOptionName())) {
            for (int i = 0; i < currentAnswer.length; i++) {
                textOutput(answerLetter[i] + " " + currentAnswer[i] + " " + probabilityOfCorrectAnswer[i] +  "%");
            }
        } else if (gameState.equals(HelpType.FIFTY_FIFTY_HELP.getHelpOptionName())) {

            for (int i = 0; i < currentAnswer.length; i++) {
                ifExistWrongAnswer = false;

                for (int j = 0; j < wrongNumbers.length; j++) {
                    if (wrongNumbers[j] == i) ifExistWrongAnswer = true;
                }
                if (ifExistWrongAnswer) textOutput(answerLetter[i] + " \u001B[9m" + currentAnswer[i] + "\u001B[0m");
                else textOutput(answerLetter[i] + " " + currentAnswer[i]);
            }
        } else if (gameState.equals(HelpType.PHONE_HELP.getHelpOptionName())) {
            for (int i = 0; i < currentAnswer.length; i++) {
                textOutput(answerLetter[i] + " " + currentAnswer[i] + " " + "-------- A friend's reply: \""+getFriendAnswer(probabilityFriendCorrectAnswer[i])+"\"");
            }
        } else {
            for (int i = 0; i < currentAnswer.length; i++) {
                textOutput(answerLetter[i] + " " + currentAnswer[i]);
            }
        }

    }

    private static String getFriendAnswer(int friendCorrectAnswer) {
        if (friendCorrectAnswer < 20) return "Unlikely";
        if (friendCorrectAnswer >= 20 & friendCorrectAnswer < 45) return "I doubt";
        if (friendCorrectAnswer >= 45 & friendCorrectAnswer < 75) return "I think... maybe this one?";
        return "I think this is the correct answer.";
    }

    private static Question getQuestionByLevel(int levelGame) {
        questionInLevel = 0;
        //for (int i = 0; i < question.length; i++) {
        for (int i = 0; i < question.size(); i++) {
           // if (question[i].getQuestionLevel() == levelGame) {
            if (question.get(i).getQuestionLevel() == levelGame) {
                //questionNumberInLevel[questionInLevel++] = question[i].getQuestionNumber();
                questionNumberInLevel[questionInLevel++] = question.get(i).getQuestionNumber();
            }
        }
        int temp = random.nextInt(questionInLevel);
        selectedIndexQuestion = questionNumberInLevel[temp] - 1;

        //System.out.println(question[selectedQuestion].getQuestionName());

       // return question[selectedIndexQuestion];
        return question.get(selectedIndexQuestion);

    }


    //Display all question and atword
    private static void displayQuestions() {
        for (int i = 0; i < questionIndex; i++) {
            for (int j = 0; j < answerIndex; j++) {
                //System.out.println(question[i]);
                 System.out.println(question.get(i));
                //System.out.println(answers[j]);
                System.out.println(answers.get(j));
            }
        }
    }

    //Display game rules
    private static void gameRules() {
        System.out.println("\n");
        textOutput("You will face 15 questions.\n" +
                "A correct answer earns you a certain number of points,\n" +
                "depending on the difficulty of the question. \n" +
                "If you answer a question incorrectly, the game ends. \n" +
                "You have three lifelines: \n" +
                "1. \"50/50\" — which eliminates two incorrect answer choices; \n" +
                "2. \"Phone-a-Friend\" — you may consult a friend for advice, for which you have exactly one minute. \n" +
                "3. \"Ask the Audience\" — to gauge the opinion of those present; \n" +
                "The game also features two guaranteed sums: 1,000 lei and 100,000 lei. \n" +
                "In the event of an incorrect answer, \n" +
                "you will receive the amount corresponding to your last reached safety net. \n\n" +
                "I wish you the best of luck.\n\n" +
                "You are ready(Y/N)");

    }

    //Print the text with pause
    private static void textOutput(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
    }

    //Make question array
    private static void setQuestions() throws FileNotFoundException {

        File file = new File("questionTable");
        // System.out.println(new File(".").getAbsolutePath());
        Scanner scanFile = new Scanner(file);
        String fileLine;
        int levelNumber;
        int questionNumber;
        String questionBody;
        String[] partLine;
        String answer1, answer2, answer3, answer4;
        int correctAnswer;

        while (scanFile.hasNextLine()) {
            fileLine = scanFile.nextLine();
            partLine = fileLine.split(";");
            levelNumber = Integer.parseInt(partLine[0]);
            questionNumber = Integer.parseInt(partLine[1]);
            questionBody = partLine[2];
            answer1 = partLine[3];
            answer2 = partLine[4];
            answer3 = partLine[5];
            answer4 = partLine[6];
            correctAnswer = Integer.parseInt(partLine[7]);
            //question[questionIndex++] = new Question(levelNumber, questionNumber, questionBody);
            question.add(new Question(levelNumber, questionNumber, questionBody));
            //answers[answerIndex++] = new Answer(levelNumber, questionNumber, answer1, answer2, answer3, answer4, correctAnswer);
            answers.add(new Answer(levelNumber, questionNumber, answer1, answer2, answer3, answer4, correctAnswer));

        }
    }


}
