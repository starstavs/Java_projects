package edu.tekwill.millionaire.controler;

import edu.tekwill.millionaire.model.Answer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelpController {
    @FXML
    public Label title;

    @FXML
    public Label helpAnswer1;

    @FXML
    public Rectangle helpValue1;

    @FXML
    public Label helpAudience1;

    @FXML
    public Label helpAnswer2;

    @FXML
    public Rectangle helpValue2;

    @FXML
    public Label helpAudience2;

    @FXML
    public Label helpAnswer3;

    @FXML
    public Rectangle helpValue3;

    @FXML
    public Label helpAudience3;

    @FXML
    public Label helpAnswer4;

    @FXML
    public Rectangle helpValue4;

    @FXML
    public Label helpAudience4;

    @FXML
    public Button okButton;

    @FXML
    public void initialize() {
        helpValue1.setVisible(true);
        helpValue2.setVisible(true);
        helpValue3.setVisible(true);
        helpValue4.setVisible(true);
        helpAudience1.setVisible(true);
        helpAudience2.setVisible(true);
        helpAudience3.setVisible(true);
        helpAudience4.setVisible(true);

    }

    @FXML
    public void helpFormClose() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();

    }


    public void setHelpDataFriend(Answer[] answer, String[] friendAnswer) {
        title.setText("Ajutor - \"Sună prietenul\"");

        helpValue1.setVisible(false);
        helpValue2.setVisible(false);
        helpValue3.setVisible(false);
        helpValue4.setVisible(false);

        helpAnswer1.setText(answer[0].getAnswerOrder().getOrderLetter() + ") " + answer[0].getAnswer());
        helpAudience1.setText(friendAnswer[0]);

        helpAnswer2.setText(answer[1].getAnswerOrder().getOrderLetter() + ") " + answer[1].getAnswer());
        helpAudience2.setText(friendAnswer[1]);

        helpAnswer3.setText(answer[2].getAnswerOrder().getOrderLetter() + ") " + answer[2].getAnswer());
        helpAudience3.setText(friendAnswer[2]);

        helpAnswer4.setText(answer[3].getAnswerOrder().getOrderLetter() + ") " + answer[3].getAnswer());
        helpAudience4.setText(friendAnswer[3]);

    }

    public void setHelpDataAudience(Answer[] answer, int[] audienceAnswer) {
        title.setText("Ajutor - \"Ajutor din auditorie\"");


        helpAnswer1.setText(answer[0].getAnswerOrder().getOrderLetter() + ") " + answer[0].getAnswer());
        helpValue1.setWidth(audienceAnswer[0]);
        helpAudience1.setText(String.valueOf(audienceAnswer[0])+"%");

        helpAnswer2.setText(answer[1].getAnswerOrder().getOrderLetter() + ") " + answer[1].getAnswer());
        helpValue2.setWidth(audienceAnswer[1]);
        helpAudience2.setText(String.valueOf(audienceAnswer[1])+"%");

        helpAnswer3.setText(answer[2].getAnswerOrder().getOrderLetter() + ") " + answer[2].getAnswer());
        helpValue3.setWidth(audienceAnswer[2]);
        helpAudience3.setText(String.valueOf(audienceAnswer[2])+"%");

        helpAnswer4.setText(answer[3].getAnswerOrder().getOrderLetter() + ") " + answer[3].getAnswer());
        helpValue4.setWidth(audienceAnswer[3]);
        helpAudience4.setText(String.valueOf(audienceAnswer[3])+"%");
    }

}
