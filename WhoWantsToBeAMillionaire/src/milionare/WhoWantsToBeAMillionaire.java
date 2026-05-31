package milionare;

import help.AudienceHelp;
import help.FiftyFiftyHelp;
import help.PhoneHelp;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;


public class WhoWantsToBeAMillionaire {
    static Scanner scan = new Scanner(System.in);                               //Scanner value
    static String playerName;                                                   //Player name
    static Question[] question = new Question[60];                              //Array with questions
    static Answer[] answers = new Answer[240];                                  //Array with answers
    static String[] currentAnswer = new String[4];                              //Array with 4 available answer for question
    static FiftyFiftyHelp fiftyFiftyHelp = new FiftyFiftyHelp(false);    //Help 50/50
    static AudienceHelp audienceHelp = new AudienceHelp(false);          //Help audience
    static PhoneHelp phoneHelp = new PhoneHelp(false);                   //Help phone
    static int questionIndex = 0, answerIndex = 0;                              //Number of questions and answers
    static boolean action;                                                      //Game is active
    static int levelGame = 0;                                                   //Selected level
    static String option;                                                       //User's Choice
    static int[] questionNumberInLevel = new int[10];                           //Number of possible questions in a level
    static int questionInLevel = 0;                                             //Current number of questions in the level
    static int selectedIndexQuestion;                                           //Selected index of question
    static Question selectedQuestion;                                           //Selected question
    static Random random = new Random();


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
            displayQuestion();
            displayAnswer();
            displayHelp();
            option = scan.nextLine();
            switch (option.toLowerCase()) {
                case "a" -> checkAnswer(1);
                case "b" -> checkAnswer(2);
                case "c" -> checkAnswer(3);
                case "d" -> checkAnswer(4);
                case "f" -> fiftyFiftyHelp.getHelp(answers[selectedIndexQuestion]);
                case "p" -> phoneHelp.getHelp(answers[selectedIndexQuestion]);
                case "s" -> audienceHelp.getHelp(answers[selectedIndexQuestion]);
                default -> System.out.println("Invalid input");
            }

            action = false;

        }
    }

    private static void checkAnswer(int selectedAnswer) {
        if (selectedAnswer == answers[selectedIndexQuestion].getCorrectAnswer()) {
            System.out.println("correct");
        } else {
            System.out.println("Oblom");
        }
    }

    private static void displayQuestion() {
        System.out.println("\n");
        textOutput("Question from the section \"" + Levels.getLevelDescriptionByNumber(levelGame) + "\"\n");
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
        currentAnswer = answers[selectedIndexQuestion].getAnswer();
        for (int i = 0; i < currentAnswer.length; i++) {
            textOutput(currentAnswer[i]);
        }

    }

    private static Question getQuestionByLevel(int levelGame) {

        for (int i = 0; i < question.length; i++) {
            if (question[i].getQuestionLevel() == levelGame) {
                questionNumberInLevel[questionInLevel++] = question[i].getQuestionNumber();
            }
        }
        int temp = random.nextInt(questionInLevel);
        selectedIndexQuestion = questionNumberInLevel[temp] - 1;

        //System.out.println(question[selectedQuestion].getQuestionName());

        return question[selectedIndexQuestion];

    }


    //Display all question and atword
    private static void displayQuestions() {
        for (int i = 0; i < questionIndex; i++) {
            for (int j = 0; j < answerIndex; j++) {
                System.out.println(question[i]);
                System.out.println(answers[j]);
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
                "The game also features two safety nets: 1,000 lei and 100,000 lei. \n" +
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
            question[questionIndex++] = new Question(levelNumber, questionNumber, questionBody);
            answers[answerIndex++] = new Answer(levelNumber, questionNumber, answer1, answer2, answer3, answer4, correctAnswer);

        }
    }


}
