package ba.unsa.etf.rpr.tutorijal6;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
class MainTest {

    @Start
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("/fxml/formular.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void nameFieldTest(FxRobot robot) {
        TextField nameField = robot.lookup("#nameField").queryAs(TextField.class);
        robot.clickOn("#nameField").write("Amir");
        assertEquals("Amir", nameField.getText());
    }

    @Test
    public void surnameFieldTest(FxRobot robot) {
        TextField surnameField = robot.lookup("#surnameField").queryAs(TextField.class);
        robot.clickOn("#surnameField").write("Nakić");
        assertEquals("Nakić", surnameField.getText());
    }

    @Test
    public void indexFieldTest(FxRobot robot) {
        TextField indexField = robot.lookup("#indexField").queryAs(TextField.class);
        robot.clickOn("#indexField").write("17787");
        assertEquals("17787", indexField.getText());
    }

    @Test
    public void genderBoxTest(FxRobot robot) {
        ChoiceBox genderBox = robot.lookup("#genderBox").queryAs(ChoiceBox.class);
        robot.clickOn("#genderBox").clickOn("Muški");
        assertEquals("Muški",genderBox.getValue().toString());
    }

    @Test
    public void emailTest(FxRobot robot) {
        TextField emailBox = robot.lookup("#eMailField").queryAs(TextField.class);
        robot.clickOn("#eMailField").write("amirnakic5@gmail.com");
        assertEquals("amirnakic5@gmail.com", emailBox.getText());
    }
}
