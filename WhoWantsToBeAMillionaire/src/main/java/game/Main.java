package game;

import help.AudienceHelp;
import help.FiftyFiftyHelp;
import help.HelpType;
import help.PhoneHelp;
import millionaire.Answer;
import millionaire.LoadingDataFromCsv;
import millionaire.Question;

import java.util.*;

public class Main {

    static Scanner scan = new Scanner(System.in);
    private static final String FILE_PATH = "input/questions_ro.csv";
    private static boolean action, isAnswered, isCorrect;
    private static int levelGame = 0;
    private static String gameState, option, outputText;
    private static Question selectedQuestion;
    private static List<Question> question, currentLevelList;
    private static Random random = new Random();
    private static Answer[] currentAnswers = new Answer[4];
    private static FiftyFiftyHelp fiftyFiftyHelp = new FiftyFiftyHelp(false);    //Help 50/50
    private static AudienceHelp audienceHelp = new AudienceHelp(false);          //Help audience
    private static PhoneHelp phoneHelp = new PhoneHelp(false);
    private static List<Answer> wrongAnswer = new ArrayList<>();
    private static int[] probabilityFriendCorrectAnswer, probabilityOfCorrectAnswer;
    private static final List<Integer> guaranteedAmountList = List.of(1000, 100000, 1000000);
    private static Player player;

    public static void main(String[] args) {

        LoadingDataFromCsv loadingDataFromCsv = new LoadingDataFromCsv();
        question = loadingDataFromCsv.loadFromCsv(FILE_PATH);


        System.out.println("Welcome to the game \"Who wants to be a millionaire\" ");
        System.out.println("What is your name?");
        player = new Player(scan.nextLine());
        System.out.println("Hallo " + player + ". I will explain the rules of the game to you.");
        gameRules();
        action = scan.nextLine().equalsIgnoreCase("Y");

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
                // textOutput("The correct answer is " + currentAnswer[(int) (answers.get(selectedIndexQuestion).getCorrectAnswer() - 1)]);

                textOutput(" You earned " + player.getGuaranteedAmount() + " lei on this game.");
                textOutput("Game is over");
                action = false;
            }
            if (levelGame == 15 || player.getGuaranteedAmount() == guaranteedAmountList.get(2)) {
                textOutput("Congratulations, " + player + "! You won our game and earned " + player.getGuaranteedAmount() + " lei.");
                action = false;
            }

        }
    }

    private static void getUserResponse() {
        while (true) {
            option = scan.nextLine();
            switch (option.toLowerCase()) {
                case "a" -> {
                    isAnswered = true;
                    isCorrect = selectedQuestion.getCorrectAnswer(0);
                }
                case "b" -> {
                    isAnswered = true;
                    isCorrect = selectedQuestion.getCorrectAnswer(1);
                }
                case "c" -> {
                    isAnswered = true;
                    isCorrect = selectedQuestion.getCorrectAnswer(2);
                }
                case "d" -> {
                    isAnswered = true;
                    isCorrect = selectedQuestion.getCorrectAnswer(3);
                }
                case "f" -> {
                    gameState = HelpType.FIFTY_FIFTY_HELP.getHelpOptionName();
                    wrongAnswer = fiftyFiftyHelp.getHelp(selectedQuestion);

                    if (wrongAnswer.isEmpty()) {
                        System.out.println("You have already used this hint.");
                        continue;
                    }

                    break;
                }
                case "p" -> {
                    gameState = HelpType.PHONE_HELP.getHelpOptionName();
                    probabilityFriendCorrectAnswer = phoneHelp.getHelp(selectedQuestion);
                    if (probabilityFriendCorrectAnswer.length == 0) {
                        System.out.println("You have already used this hint.");
                        continue;
                    }

                    break;
                }
                case "s" -> {
                    gameState = HelpType.AUDIENCE_HELP.getHelpOptionName();
                    //probabilityOfCorrectAnswer = audienceHelp.getHelp(answers[selectedIndexQuestion], answers[selectedIndexQuestion].getCorrectAnswer());
                    probabilityOfCorrectAnswer = audienceHelp.getHelp(selectedQuestion);
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
        if (isAnswered) {
            if (isCorrect) {
                player.setScore(selectedQuestion.getQuestionScore());
                textOutput("Congratulations, you gave the correct answer, which earned you " + selectedQuestion.getQuestionScore() + " lei.");
                if (guaranteedAmountList.contains(selectedQuestion.getQuestionScore())) {
                    player.setGuaranteedAmount(selectedQuestion.getQuestionScore());
                    textOutput("This is your guaranteed amount. ");
                }

            }
        }

    }

//    private static boolean checkAnswer(int selectedAnswer) {
//        isAnswered = true;
//        //if (selectedAnswer == answers[selectedIndexQuestion].getCorrectAnswer()) {
//        if (selectedAnswer == answers.get(selectedIndexQuestion).getCorrectAnswer()) {
//            textOutput("Congratulations! That is the correct answer.");
//            currentAmount = Levels.getLevelBonusByNumber(levelGame);
//            textOutput("You earned " + currentAmount + " lei for the correct answer to the question.");
//            for (int sum : guaranteedAmountArray) {
//                if (currentAmount == sum) {
//                    guaranteedAmount = currentAmount;
//                    textOutput("You have reached your guaranteed amount and it is " + guaranteedAmount + " lei.");
//                    break;
//                }
//            }
//            return true;
//
//        } else {
//            return false;
//        }
//    }

    private static void displayQuestion() {
        System.out.println("\n");
        textOutput("Question from level " + levelGame + ".");
        selectedQuestion = getQuestionByLevel(levelGame);
        textOutput("The cost of the question is " + selectedQuestion.getQuestionScore() + " lei.");
        System.out.println("\n");

        textOutput(selectedQuestion.getQuestionName());

    }

    private static void displayAnswer() {

        currentAnswers = selectedQuestion.getAnswers();

        for (int i = 0; i < currentAnswers.length; i++) {
            outputText = "";
            outputText += currentAnswers[i].getAnswerOrder().getOrderLetter() + " ";
            if (!currentAnswers[i].isVisible()) {
                outputText += "\u001B[9m";
            }
            outputText += currentAnswers[i].getAnswer();

            if (!currentAnswers[i].isVisible()) {
                outputText += "\u001B[0m";
            }

            if (probabilityFriendCorrectAnswer != null && probabilityFriendCorrectAnswer.length > 0) {
                outputText += "-- A friend's reply: \"" + getFriendAnswer(probabilityFriendCorrectAnswer[i]) + "\"  ";
            }

            if (probabilityOfCorrectAnswer != null && probabilityOfCorrectAnswer.length > 0) {
                outputText += "  ---Audience choice is " + probabilityOfCorrectAnswer[i] + "%";
            }
            textOutput(outputText);
        }
    }

    private static void displayHelp() {
        textOutput("------Help------");
        textOutput(fiftyFiftyHelp + " | " + phoneHelp + " | " + audienceHelp);
    }

//    private static void displayAnswerOptions(int selectedIndexQuestion) {
//        //currentAnswer = answers[selectedIndexQuestion].getAnswer();
//        currentAnswer = answers.get(selectedIndexQuestion).getAnswer();
//
//        if (gameState.equals(HelpType.AUDIENCE_HELP.getHelpOptionName())) {
//            for (int i = 0; i < currentAnswer.length; i++) {
//                textOutput(answerLetter[i] + " " + currentAnswer[i] + " " + probabilityOfCorrectAnswer[i] + "%");
//            }
//        } else if (gameState.equals(HelpType.FIFTY_FIFTY_HELP.getHelpOptionName())) {
//
//            for (int i = 0; i < currentAnswer.length; i++) {
//                ifExistWrongAnswer = false;
//
//                for (int j = 0; j < wrongNumbers.length; j++) {
//                    if (wrongNumbers[j] == i) ifExistWrongAnswer = true;
//                }
//                if (ifExistWrongAnswer) textOutput(answerLetter[i] + " \u001B[9m" + currentAnswer[i] + "\u001B[0m");
//                else textOutput(answerLetter[i] + " " + currentAnswer[i]);
//            }
//        } else if (gameState.equals(HelpType.PHONE_HELP.getHelpOptionName())) {
//            for (int i = 0; i < currentAnswer.length; i++) {
//                textOutput(answerLetter[i] + " " + currentAnswer[i] + " " + "-------- A friend's reply: \"" + getFriendAnswer(probabilityFriendCorrectAnswer[i]) + "\"");
//            }
//        } else {
//            for (int i = 0; i < currentAnswer.length; i++) {
//                textOutput(answerLetter[i] + " " + currentAnswer[i]);
//            }
//        }
//
//    }

    private static String getFriendAnswer(int friendCorrectAnswer) {

        if (friendCorrectAnswer < 20) return "Unlikely";
        if (friendCorrectAnswer >= 20 & friendCorrectAnswer < 45) return "I doubt";
        if (friendCorrectAnswer >= 45 & friendCorrectAnswer < 75) return "I think... maybe this one?";
        return "I think this is the correct answer.";
    }

    private static Question getQuestionByLevel(int levelGame) {

        currentLevelList = question.stream()
                .filter(question -> question.getQuestionLevel() == levelGame)
                .toList();
        int temp = random.nextInt(currentLevelList.size() - 1);

        return currentLevelList.get(temp);

    }
//    questionInLevel = 0;
//        //for (int i = 0; i < question.length; i++) {
//        for (int i = 0; i < question.size(); i++) {
//            // if (question[i].getQuestionLevel() == levelGame) {
//            if (question.get(i).getQuestionLevel() == levelGame) {
//                //questionNumberInLevel[questionInLevel++] = question[i].getQuestionNumber();
//                questionNumberInLevel[questionInLevel++] = question.get(i).getQuestionNumber();
//            }
//        }
//        int temp = random.nextInt(questionInLevel);
//        selectedIndexQuestion = questionNumberInLevel[temp] - 1;
//
//        //System.out.println(question[selectedQuestion].getQuestionName());
//
//        // return question[selectedIndexQuestion];
//        return question.get(selectedIndexQuestion);
//
//    }


    //Display all question and atword
//    private static void displayQuestions() {
//        for (int i = 0; i < questionIndex; i++) {
//            for (int j = 0; j < answerIndex; j++) {
//                //System.out.println(question[i]);
//                System.out.println(question.get(i));
//                //System.out.println(answers[j]);
//                System.out.println(answers.get(j));
//            }
//        }
//    }

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
//    private static void setQuestions() throws FileNotFoundException {
//
//        File file = new File("questionTable");
//        // System.out.println(new File(".").getAbsolutePath());
//        Scanner scanFile = new Scanner(file);
//        String fileLine;
//        int levelNumber;
//        int questionNumber;
//        String questionBody;
//        String[] partLine;
//        String answer1, answer2, answer3, answer4;
//        int correctAnswer;
//
//        while (scanFile.hasNextLine()) {
//            fileLine = scanFile.nextLine();
//            partLine = fileLine.split(";");
//            levelNumber = Integer.parseInt(partLine[0]);
//            questionNumber = Integer.parseInt(partLine[1]);
//            questionBody = partLine[2];
//            answer1 = partLine[3];
//            answer2 = partLine[4];
//            answer3 = partLine[5];
//            answer4 = partLine[6];
//            correctAnswer = Integer.parseInt(partLine[7]);
//            //question[questionIndex++] = new Question(levelNumber, questionNumber, questionBody);
//            question.add(new Question(levelNumber, questionNumber, questionBody));
//            //answers[answerIndex++] = new Answer(levelNumber, questionNumber, answer1, answer2, answer3, answer4, correctAnswer);
//            answers.add(new Answer(levelNumber, questionNumber, answer1, answer2, answer3, answer4, correctAnswer));
//
//        }
//    }


}





