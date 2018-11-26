package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

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
    public boolean imeValidno;
    public boolean prezimeValidno;
    public boolean indeksValidan;

    public boolean validnoIme(String s) {
        if (s.length() > 20 || s.length() < 1) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(Character.isLetter(c) || c==' ')) return false;
        }
        return true;
    }

    public boolean validnoPrezime(String s) {
        if (s.length() > 20 || s.length() < 1) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(Character.isLetter(c) || c=='-')) return false;
        }
        return true;
    }

    public boolean validanIndeks(String s) {
        if (s.length() != 5) return false;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    @FXML
    public void initialize() {
        imeValidno = false;
        nameField.getStyleClass().add("poljeNeispravno");
        nameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoIme(n)) {
                    nameField.getStyleClass().removeAll("poljeNeispravno");
                    nameField.getStyleClass().add("poljeIspravno");
                    imeValidno = true;
                } else {
                    nameField.getStyleClass().removeAll("poljeIspravno");
                    nameField.getStyleClass().add("poljeNeispravno");
                    imeValidno = false;
                }
            }
        });
        prezimeValidno = false;
        surnameField.getStyleClass().add("poljeNeispravno");
        surnameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoPrezime(n)) {
                    surnameField.getStyleClass().removeAll("poljeNeispravno");
                    surnameField.getStyleClass().add("poljeIspravno");
                    prezimeValidno = true;
                } else {
                    surnameField.getStyleClass().removeAll("poljeIspravno");
                    surnameField.getStyleClass().add("poljeNeispravno");
                    prezimeValidno = false;
                }
            }
        });
        indeksValidan = false;
        indexField.getStyleClass().add("poljeNeispravno");
        indexField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanIndeks(n)) {
                    indexField.getStyleClass().removeAll("poljeNeispravno");
                    indexField.getStyleClass().add("poljeIspravno");
                    indeksValidan = true;
                } else {
                    indexField.getStyleClass().removeAll("poljeIspravno");
                    indexField.getStyleClass().add("poljeNeispravno");
                    indeksValidan = false;
                }
            }
        });
    }

    public void clickOnConfirm(ActionEvent actionEvent) {
    }
}
