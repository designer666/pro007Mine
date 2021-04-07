package javafx.lesson01.controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {

    @FXML private TextField fldLogin;

    @FXML private PasswordField fldConfirm;

    @FXML private PasswordField fldPassword;

    @FXML
    private void registrationOnClick() {
        if (fldPassword.getText().equals(fldConfirm.getText())) {
            System.out.println("New User: ");
            System.out.println("Loin: " + fldLogin.getText());
            System.out.println("Password: " + fldPassword.getText());
        } else {
            System.err.println("Password confirm wrong!");
        }
    }

    @FXML
    private void canselOnClick() {
        System.exit(0);
    }
}
