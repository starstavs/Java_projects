package edu.tekwill.millionaire.controler;

import edu.tekwill.millionaire.Main;
import edu.tekwill.millionaire.game.Game;
import edu.tekwill.millionaire.model.Answer;
import edu.tekwill.millionaire.model.Player;
import edu.tekwill.millionaire.model.Question;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;


public class GameController {

    @FXML
    private Label levelNumber;

    @FXML
    private Label questionLabel;

    @FXML
    private Label playerName;

    @FXML
    private Label playerScore;

    @FXML
    private Button helpFiftyFifty;

    @FXML
    private Button helpFriend;

    @FXML
    private Button helpAudience;

    @FXML
    private Button answer1;

    @FXML
    private Button answer2;

    @FXML
    private Button answer3;

    @FXML
    private Button answer4;


    @FXML
    private TextArea playerRecords;

    private Player player;
    private boolean gameActiv = true, isWinner = false;

    private Game game;
    private String defaultButtonStyle;
    private Paint defaultLabelStyle;
    private Button[] answerButtons = {answer1, answer2, answer3, answer4};
    private Answer[] answers;
    private Question selectedQuestion;
    private String[] friendAnswer;
    private int[] audienceHelp;

    @FXML
    public void initialize() {
        System.out.println("Game started");
        answerButtons = new Button[]{answer1, answer2, answer3, answer4};
    }

    @FXML
    public void startGame(Player player) {
        this.player = player;
        game = new Game(player);
        playerName.setText(player.getName());
        defaultButtonStyle = answer1.getStyle();
        defaultLabelStyle = questionLabel.getTextFill();

        showQuestion();

    }

    @FXML
    public void showQuestion() {
        setDefaultStyle();

        selectedQuestion = game.displayQuestion();
        questionLabel.setText(String.valueOf(selectedQuestion.getQuestionName()));
        playerScore.setText(String.valueOf(player.getScore()));
        levelNumber.setText(String.valueOf(game.getLevelGame()));

        answers = selectedQuestion.getAnswers();
        answer1.setText(answers[0].getAnswerOrder().getOrderLetter() + ") " + answers[0].getAnswer());
        answer2.setText(answers[1].getAnswerOrder().getOrderLetter() + ") " + answers[1].getAnswer());
        answer3.setText(answers[2].getAnswerOrder().getOrderLetter() + ") " + answers[2].getAnswer());
        answer4.setText(answers[3].getAnswerOrder().getOrderLetter() + ") " + answers[3].getAnswer());
    }


    @FXML
    protected void checkAnswer1() {
        if (game.getCorrectAnswer(0)) {
            answer1.setStyle("-fx-background-color: green;");
            questionLabel.setText("Felicitări! Răspunsul este corect!");
            questionLabel.setTextFill(Color.GREEN);
            GetPause();

        } else {
            answer1.setStyle("-fx-background-color: red;");
            wrongAnswer();

        }


    }


    @FXML
    protected void checkAnswer2() {
        if (game.getCorrectAnswer(1)) {
            answer2.setStyle("-fx-background-color: green;");
            questionLabel.setText("Felicitări! Răspunsul este corect!\n");

            questionLabel.setTextFill(Color.GREEN);
            GetPause();

        } else {
            answer2.setStyle("-fx-background-color: red;");
            wrongAnswer();

        }


    }

    @FXML
    protected void checkAnswer3() {
        if (game.getCorrectAnswer(2)) {
            answer3.setStyle("-fx-background-color: green;");
            questionLabel.setText("Felicitări! Răspunsul este corect!");
            questionLabel.setTextFill(Color.GREEN);
            GetPause();

        } else {
            answer3.setStyle("-fx-background-color: red;");
            wrongAnswer();

        }


    }

    @FXML
    protected void checkAnswer4() {
        if (game.getCorrectAnswer(3)) {
            answer4.setStyle("-fx-background-color: green;");
            questionLabel.setText("Felicitări! Răspunsul este corect!");
            questionLabel.setTextFill(Color.GREEN);
            GetPause();

        } else {
            answer4.setStyle("-fx-background-color: red;");
            wrongAnswer();

        }

    }

    @FXML
    private void getHelpFiftyFifty() {
        List<Answer> wrongAnswer = game.getFiftyFifty();
        if (wrongAnswer.size() > 0) {
            System.out.println(wrongAnswer.size());
            System.out.println(answers.length);
            for (int i = 0; i < answers.length; i++) {
                if (!answers[i].isVisible()) {
                    answerButtons[i].setVisible(false);
                    helpFiftyFifty.setDisable(true);
                }
            }
        }
    }

    @FXML
    private void getHelpPhone() {
        friendAnswer = game.getPhoneHelp();
        showPhoneHelp();
        helpFriend.setDisable(true);
    }

    @FXML
    private void getHelpAudience() {
        audienceHelp = game.getAudienceHelp();
        showAudienceHelp();
        helpAudience.setDisable(true);
    }

    private void GetPause() {
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {

            if (!gameActiv) {
                gameOver();
            } else {
                showQuestion();
            }

        });

        pause.play();

    }

    public void setDefaultStyle() {
        answer1.setStyle(defaultButtonStyle);
        answer2.setStyle(defaultButtonStyle);
        answer3.setStyle(defaultButtonStyle);
        answer4.setStyle(defaultButtonStyle);
        questionLabel.setTextFill(defaultLabelStyle);
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        answer4.setVisible(true);
    }

    private void wrongAnswer() {
        questionLabel.setText("Răspunsul este greșit!\n" +
                "Răspunsul corect este \"" + (selectedQuestion.getCorrectAnswer().getAnswer()) + "\"\n");
        questionLabel.setTextFill(Color.RED);
        answerButtons[selectedQuestion.getCorrectAnswerIndex()].setStyle("-fx-background-color: green;");
        gameActiv = false;
        GetPause();
    }


    public void showPhoneHelp() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("help-view.fxml"));
            Parent root = loader.load();
            HelpController controller = loader.getController();
            controller.setHelpDataFriend(answers, friendAnswer);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showAudienceHelp() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("help-view.fxml"));
            Parent root = loader.load();
            HelpController controller = loader.getController();
            controller.setHelpDataAudience(answers, audienceHelp);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void gameOver() {
        answer1.setVisible(false);
        answer2.setVisible(false);
        answer3.setVisible(false);
        answer4.setVisible(false);
        helpAudience.setVisible(false);
        helpFriend.setVisible(false);
        helpFiftyFifty.setVisible(false);
        if (isWinner) {
            questionLabel.setText("Felicitări! Ați câștigat " + player.getGuaranteedAmount() + " lei");
            questionLabel.setTextFill(Color.GREEN);
        } else {
            questionLabel.setText("Ne pare rău, că de data aceasta\n nu ați răspuns la toate întrebările.\n\n" +
                    "În aceasta joacă ați câștigat " + player.getGuaranteedAmount() + " lei");
            questionLabel.setTextFill(Color.RED);
        }

    }

}
