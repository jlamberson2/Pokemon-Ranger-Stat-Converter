import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class pokemonController implements Initializable {

    StatConvert stats = new StatConvert();

    @FXML
    private Pane primaryStage;

    @FXML
    private TextField attackInput;

    @FXML
    private Button convertButton;

    @FXML
    private TextField defenseInput;

    @FXML
    private TextField hpInput;

    @FXML
    private TextArea output;

    @FXML
    private TextField spAttackInput;

    @FXML
    private TextField spDefenseInput;

    @FXML
    private TextField speedInput;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        output.setEditable(false);

    }

    //Action of the convert button, if none of the fields contain only numbers, proc an error message
    @FXML
    void initalizeConvert(ActionEvent event) {
        //checks to make sure inputs are only numbers
        if(attackInput.getText().matches("[0-9]+") && defenseInput.getText().matches("[0-9]+") && spAttackInput.getText().matches("[0-9]+") && spDefenseInput.getText().matches("[0-9]+") && hpInput.getText().matches("[0-9]+") && speedInput.getText().matches("[0-9]+")){
            stats = new StatConvert(Integer.parseInt(hpInput.getText()), Integer.parseInt(attackInput.getText()), Integer.parseInt(defenseInput.getText()), Integer.parseInt(spAttackInput.getText()), Integer.parseInt(spDefenseInput.getText()), Integer.parseInt(speedInput.getText()));
            ArrayList<Integer> convertedStats = stats.getStats();

            String toPost = "Strength: " + convertedStats.get(0) + "\nDexterity: " + convertedStats.get(1) + "\nConstitution: " + convertedStats.get(2) + "\n" +
                    "Intelligence: " + convertedStats.get(3) + "\nWisdom: " + convertedStats.get(4) + "\nCharisma: " + convertedStats.get(5) + "\n";

            output.setText(toPost);

        } else {
            Stage stage = (Stage) primaryStage.getScene().getWindow();
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);

            alert.getDialogPane().setHeaderText("Error, inputs to any stats can only be numbers");

            alert.showAndWait();
        }
    }

}
