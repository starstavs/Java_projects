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
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {

    // static Scanner scan = new Scanner(System.in);
    private final String FILE_PATH = "input/questions_ro.csv";
    private final String FILE_USER_RECORDS_PATH = "output/user_data.csv";
    private boolean isAnswered, isCorrect;
    private int levelGame = 0;
    private String option, outputText;
    private Question selectedQuestion;
    private List<Question> questions, currentLevelList;
    private List<PlayerRecords> playerRecordsList;
    private Random random = new Random();
    private Answer[] currentAnswers = new Answer[4];
    private FiftyFiftyHelp fiftyFiftyHelp = new FiftyFiftyHelp(false);    //Help 50/50
    private AudienceHelp audienceHelp = new AudienceHelp(false);          //Help audience
    private PhoneHelp phoneHelp = new PhoneHelp(false);
    private List<Answer> wrongAnswer = new ArrayList<>();
    private int[] probabilityFriendCorrectAnswer, probabilityOfCorrectAnswer;
    private final List<Integer> guaranteedAmountList = List.of(1000, 100000, 1000000);
    private Player player;


    public Game(Player player) {
        this.player = player;
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

    public List<Answer> getFiftyFifty() {
        wrongAnswer = fiftyFiftyHelp.getHelp(selectedQuestion);
        if (wrongAnswer.isEmpty()) return Collections.emptyList();
        return wrongAnswer;
    }

    public String[] getPhoneHelp() {
        probabilityFriendCorrectAnswer = phoneHelp.getHelp(selectedQuestion);
        if (probabilityFriendCorrectAnswer.length == 0) {
            return new String[0];
        }

        String[] friendAnswer = new String[4];
        for (int i = 0; i < probabilityFriendCorrectAnswer.length; i++) {
            System.out.println();
            friendAnswer[i] = getFriendAnswer(probabilityFriendCorrectAnswer[i]);
        }
        return friendAnswer;
    }

    public int[] getAudienceHelp() {
        probabilityOfCorrectAnswer = audienceHelp.getHelp(selectedQuestion);
        if (probabilityOfCorrectAnswer.length == 0) {
            return new int[0];
        }
          return probabilityOfCorrectAnswer;
    }

    private static String getFriendAnswer(int friendCorrectAnswer) {

        if (friendCorrectAnswer < 20) return "Este răspuns greșit.";
        if (friendCorrectAnswer >= 20 & friendCorrectAnswer < 45) return "Nu cred, că este corect.";
        if (friendCorrectAnswer >= 45 & friendCorrectAnswer < 65) return "Posibil să fie răspuns corect.";
        return "Eu sunt convis că acest răspuns este corect.";
    }

}





