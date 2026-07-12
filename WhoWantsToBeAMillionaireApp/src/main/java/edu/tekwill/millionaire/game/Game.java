package edu.tekwill.millionaire.game;

import edu.tekwill.millionaire.model.Player;
import edu.tekwill.millionaire.help.AudienceHelp;
import edu.tekwill.millionaire.help.FiftyFiftyHelp;
import edu.tekwill.millionaire.help.PhoneHelp;
import edu.tekwill.millionaire.service.LoadingQuestionFromCsv;
import edu.tekwill.millionaire.service.PlayerRecordsCsvLoader;
import edu.tekwill.millionaire.model.Answer;
import edu.tekwill.millionaire.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    // static Scanner scan = new Scanner(System.in);
    private static final String FILE_PATH = "input/questions_ro.csv";
    private static final String FILE_USER_RECORDS_PATH = "output/user_data.csv";
    private static boolean isAnswered, isCorrect;
    private static int levelGame = 0;
    private static String option, outputText;
    private static Question selectedQuestion;
    private List<Question> questions, currentLevelList;
    private static List<PlayerRecords> playerRecordsList;
    private static Random random = new Random();
    private static Answer[] currentAnswers = new Answer[4];
    private static FiftyFiftyHelp fiftyFiftyHelp = new FiftyFiftyHelp(false);    //Help 50/50
    private static AudienceHelp audienceHelp = new AudienceHelp(false);          //Help audience
    private static PhoneHelp phoneHelp = new PhoneHelp(false);
    private static List<Answer> wrongAnswer = new ArrayList<>();
    private static int[] probabilityFriendCorrectAnswer, probabilityOfCorrectAnswer;
    private static final List<Integer> guaranteedAmountList = List.of(1000, 100000, 1000000);
    private static Player player;


    public Game() {
        LoadingQuestionFromCsv loadingDataFromCsv = new LoadingQuestionFromCsv();
        questions = loadingDataFromCsv.loadFromCsv(FILE_PATH);
        PlayerRecordsCsvLoader playerRecordsCsvLoader = new PlayerRecordsCsvLoader();
        playerRecordsList = playerRecordsCsvLoader.loadPlayerFromCsv(FILE_USER_RECORDS_PATH);

    }


    public int getLevelGame() {
        return levelGame;
    }


    public Question displayQuestion() {
        levelGame++;
        selectedQuestion = getQuestionByLevel(levelGame);
        /// textOutput("The cost of the question is " + selectedQuestion.getQuestionScore() + " lei.");
        /// System.out.println("\n");

        //textOutput(selectedQuestion.getQuestionName());
        return selectedQuestion;
    }

    private Question getQuestionByLevel(int levelGame) {

        currentLevelList = questions.stream()
                .filter(question -> question.getQuestionLevel() == levelGame)
                .toList();
        int temp = random.nextInt(currentLevelList.size() - 1);
        return currentLevelList.get(temp);

    }

    public boolean getCorrectAnswer(int index) {
        isCorrect = selectedQuestion.getCorrectAnswer(index);
        if (isCorrect) {
            player.setScore(selectedQuestion.getQuestionScore());
            if (guaranteedAmountList.contains(selectedQuestion.getQuestionScore())) {
                player.setGuaranteedAmount(selectedQuestion.getQuestionScore());
            }
        }
        return isCorrect;
    }


   // public static void hjh() {

        // System.out.println("Welcome to the game \"Who wants to be a millionaire\" ");
        //System.out.println("What is your name?");
        // player = new Player(scan.nextLine());
        //System.out.println("Hallo " + player + ". I will explain the rules of the game to you.");
        // gameRules();
        //action = scan.nextLine().equalsIgnoreCase("Y");


//    private static void getUserResponse() {
//        while (true) {
//            option = scan.nextLine();
//            switch (option.toLowerCase()) {
//                case "a" -> {
//                    isAnswered = true;
//                    isCorrect = selectedQuestion.getCorrectAnswer(0);
//                }
//                case "b" -> {
//                    isAnswered = true;
//                    isCorrect = selectedQuestion.getCorrectAnswer(1);
//                }
//                case "c" -> {
//                    isAnswered = true;
//                    isCorrect = selectedQuestion.getCorrectAnswer(2);
//                }
//                case "d" -> {
//                    isAnswered = true;
//                    isCorrect = selectedQuestion.getCorrectAnswer(3);
//                }
//                case "f" -> {
//                    wrongAnswer = fiftyFiftyHelp.getHelp(selectedQuestion);
//
//                    if (wrongAnswer.isEmpty()) {
//                        System.out.println("You have already used this hint.");
//                        continue;
//                    }
//
//                    break;
//                }
//                case "p" -> {
//                    probabilityFriendCorrectAnswer = phoneHelp.getHelp(selectedQuestion);
//                    if (probabilityFriendCorrectAnswer.length == 0) {
//                        System.out.println("You have already used this hint.");
//                        continue;
//                    }
//                    break;
//                }
//                case "s" -> {
//                    probabilityOfCorrectAnswer = audienceHelp.getHelp(selectedQuestion);
//                    if (probabilityOfCorrectAnswer.length == 0) {
//                        System.out.println("You have already used this hint.");
//                        continue;
//                    }
//                    break;
//                }
//
//                default -> {
//                    textOutput("You pressed the wrong button out of nervousness. :)");
//                    textOutput("Come on, let's try one more time.");
//                    continue;
//                }
//
//            }
//            break;
//        }
//        if (isAnswered) {
//            if (isCorrect) {
//                player.setScore(selectedQuestion.getQuestionScore());
//                textOutput("Congratulations, you gave the correct answer, which earned you " + selectedQuestion.getQuestionScore() + " lei.");
//                if (guaranteedAmountList.contains(selectedQuestion.getQuestionScore())) {
//                    player.setGuaranteedAmount(selectedQuestion.getQuestionScore());
//                    textOutput("This is your guaranteed amount - " + player.getGuaranteedAmount() + " lei.");
//                }
//
//            }
//        }
//
//    }
//
//
//    private static void displayAnswer() {
//
//        currentAnswers = selectedQuestion.getAnswers();
//
//        for (int i = 0; i < currentAnswers.length; i++) {
//            outputText = "";
//            outputText += currentAnswers[i].getAnswerOrder().getOrderLetter() + " ";
//            if (!currentAnswers[i].isVisible()) {
//                outputText += "\u001B[9m";
//            }
//            outputText += currentAnswers[i].getAnswer();
//
//            if (!currentAnswers[i].isVisible()) {
//                outputText += "\u001B[0m";
//            }
//
//            if (probabilityFriendCorrectAnswer != null && probabilityFriendCorrectAnswer.length > 0) {
//                outputText += "-- A friend's reply: \"" + getFriendAnswer(probabilityFriendCorrectAnswer[i]) + "\"  ";
//            }
//
//            if (probabilityOfCorrectAnswer != null && probabilityOfCorrectAnswer.length > 0) {
//                outputText += "  ---Audience choice is " + probabilityOfCorrectAnswer[i] + "%";
//            }
//            textOutput(outputText);
//        }
//    }
//
//    private static void displayHelp() {
//        textOutput("------Help------");
//        textOutput(fiftyFiftyHelp + " | " + phoneHelp + " | " + audienceHelp);
//    }
//
//
//    private static String getFriendAnswer(int friendCorrectAnswer) {
//
//        if (friendCorrectAnswer < 20) return "Unlikely";
//        if (friendCorrectAnswer >= 20 & friendCorrectAnswer < 45) return "I doubt";
//        if (friendCorrectAnswer >= 45 & friendCorrectAnswer < 75) return "I think... maybe this one?";
//        return "I think this is the correct answer.";
//    }
//
//
////
//
//    //Display game rules
//    private static void gameRules() {
//        System.out.println("\n");
//        textOutput("You will face 15 questions.\n" +
//                "A correct answer earns you a certain number of points,\n" +
//                "depending on the difficulty of the question. \n" +
//                "If you answer a question incorrectly, the game ends. \n" +
//                "You have three lifelines: \n" +
//                "1. \"50/50\" — which eliminates two incorrect answer choices; \n" +
//                "2. \"Phone-a-Friend\" — you may consult a friend for advice, for which you have exactly one minute. \n" +
//                "3. \"Ask the Audience\" — to gauge the opinion of those present; \n" +
//                "The game also features two guaranteed sums: 1,000 lei and 100,000 lei. \n" +
//                "In the event of an incorrect answer, \n" +
//                "you will receive the amount corresponding to your last reached safety net. \n\n" +
//                "I wish you the best of luck.\n\n" +
//                "You are ready(Y/N)");
//
//    }
//
//    //Print the text with pause
//    private static void textOutput(String text) {
//        for (int i = 0; i < text.length(); i++) {
//            System.out.print(text.charAt(i));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("\n");
//    }

    }





