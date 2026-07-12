package edu.tekwill.millionaire.controler;

import edu.tekwill.millionaire.Main;
import edu.tekwill.millionaire.game.Rules;
import edu.tekwill.millionaire.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private TextField playerName;


    @FXML
    private TextArea rulesArea;

    @FXML
    private Button okButton;

    @FXML
    public void initialize() {

        Rules rules = new Rules();
        rulesArea.setText(rules.getRules());


    }

    @FXML
    private void startGame() throws IOException {
        Player player = new Player(playerName.getText());
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("game-view.fxml"));
        Parent root = loader.load();
        GameController controller = loader.getController();
        controller.startGame(player);
        Scene scene = new Scene(root);
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
