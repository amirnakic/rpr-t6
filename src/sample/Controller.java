package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    private SimpleStringProperty username;

    public TextField nameField;
    public TextField surnameField;
    public TextField indexField;
    public TextField jmbgField;
    public DatePicker dateField;
    public ComboBox placeOfBirthField;
    public TextField adressField;
    public TextField telephoneField;
    public TextField eMailField;
    public ChoiceBox departmentBox;
    public ChoiceBox yearBox;
    public ChoiceBox cycleBox;
    public ChoiceBox statusBox;
    public ChoiceBox categoryBox;
    public Button confirmButton;

    public Controller() {
        username = new SimpleStringProperty("");
    }

    @FXML
    public void initialize() {
        nameField.textProperty().bindBidirectional(username);
        surnameField.textProperty().bindBidirectional(username);
        indexField.textProperty().bindBidirectional(username);
        jmbgField.textProperty().bindBidirectional(username);
        adressField.textProperty().bindBidirectional(username);
        telephoneField.textProperty().bindBidirectional(username);
        eMailField.textProperty().bindBidirectional(username);
    }

    public void clickOnConfirm(ActionEvent actionEvent) {
    }
}
