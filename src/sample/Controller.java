package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class Controller {

    public TextField nameField;
    public TextField surnameField;
    public TextField indexField;
    public ChoiceBox genderBox;
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
    public boolean jmbgValidan;
    public boolean datumValidan;
    //public boolean mjestoValidno;

    public boolean validnoIme(String s) {
        if (s.length() > 20 || s.length() < 1) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(Character.isLetter(c) || c == ' ')) return false;
        }
        return true;
    }

    public boolean validnoPrezime(String s) {
        if (s.length() > 20 || s.length() < 1) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(Character.isLetter(c) || c == '-')) return false;
        }
        return true;
    }

    public boolean validanIndeks(String s) {
        if (s.length() != 5) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public boolean validanJmbg(String jmbg) {
        if (jmbg.length() != 13) return false;
        else if (dateField.getValue() == null) return false;
        else if (genderBox.getValue() == null) return false;
        for (int i = 0; i < jmbg.length(); i++) {
            char c = jmbg.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        int dan = (jmbg.charAt(0) - '0') * 10 + (jmbg.charAt(1) - '0');
        int mjesec = (jmbg.charAt(2) - '0') * 10 + (jmbg.charAt(3) - '0');
        int godina = 1000 + (jmbg.charAt(4) - '0') * 100 + (jmbg.charAt(5) - '0') * 10 + (jmbg.charAt(6) - '0');
        LocalDate date = dateField.getValue();
        if (dan != date.getDayOfMonth() || mjesec != date.getMonthValue() || godina != date.getYear()) return false;
        int politickaRegija = (jmbg.charAt(7) - '0') * 10 + (jmbg.charAt(8) - '0');
        if (politickaRegija < 0 || politickaRegija > 96) return false;
        int jedinstveniBroj = (jmbg.charAt(9) - '0') * 100 + (jmbg.charAt(10) - '0') * 10 + (jmbg.charAt(11) - '0');
        String s = (String) genderBox.getValue();
        if (s == "Muški" && (jedinstveniBroj < 0 || jedinstveniBroj > 499)) return false;
        else if (s == "Ženski" && (jedinstveniBroj > 999 || jedinstveniBroj < 500)) return false;
        int kontrolnaCifra = 11 - ((7 * ((jmbg.charAt(0) - '0') + (jmbg.charAt(6) - '0')) + 6 * ((jmbg.charAt(1) - '0') + (jmbg.charAt(7) - '0')) + 5 * ((jmbg.charAt(2) - '0') + (jmbg.charAt(8) - '0')) + 4 * ((jmbg.charAt(3) - '0') + (jmbg.charAt(9) - '0')) + 3 * ((jmbg.charAt(4) - '0') + (jmbg.charAt(10) - '0')) + 2 * ((jmbg.charAt(5) - '0') + (jmbg.charAt(11) - '0'))) % 11);
        if (kontrolnaCifra > 9) kontrolnaCifra = 0;
        if (kontrolnaCifra != (jmbg.charAt(12) - '0')) return false;
        return true;
    }

    public boolean validanDatum(LocalDate date) {
        if (dateField.getValue() == null) return false;
        LocalDate date1 = LocalDate.now();
        if (date.getYear() > date1.getYear()) return false;
        else if (date.getMonthValue() > date1.getMonthValue() && date.getYear() == date1.getYear()) return false;
        else if (date.getDayOfMonth() > date1.getDayOfMonth() && date.getMonthValue() == date1.getMonthValue() && date.getYear() == date1.getYear())
            return false;
        return true;
    }

    /*public boolean validnoMjesto(String s) {
        if (s.isEmpty() || s.length() > 20) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c)) return false;
        }
        return true;
    }*/

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
        jmbgValidan = false;
        jmbgField.getStyleClass().add("poljeNeispravno");
        jmbgField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanJmbg(n)) {
                    jmbgField.getStyleClass().removeAll("poljeNeispravno");
                    jmbgField.getStyleClass().add("poljeIspravno");
                    jmbgValidan = true;
                } else {
                    jmbgField.getStyleClass().removeAll("poljeIspravno");
                    jmbgField.getStyleClass().add("poljeNeispravno");
                    jmbgValidan = false;
                }
            }
        });
        datumValidan = false;
        dateField.getStyleClass().add("poljeNeispravno");
        dateField.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                if (validanDatum(newValue)) {
                    dateField.getStyleClass().removeAll("poljeNeispravno");
                    dateField.getStyleClass().add("poljeIspravno");
                    datumValidan = true;
                } else {
                    dateField.getStyleClass().removeAll("poljeIspravno");
                    dateField.getStyleClass().add("poljeNeispravno");
                    datumValidan = false;
                }
            }
        });

    }

    public void clickOnConfirm(ActionEvent actionEvent) {
    }
}

