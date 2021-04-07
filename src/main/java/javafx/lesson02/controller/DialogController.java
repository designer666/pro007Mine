package javafx.lesson02.controller;

import javafx.fxml.FXML;
import javafx.lesson02.domain.Contact;
import javafx.lesson02.model.ContactModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DialogController {

    @FXML private GridPane dialog;

    @FXML private TextField fldName;

    @FXML private TextField fldSurame;

    @FXML private TextField fldPhone;

    @FXML private TextField fldEmail;

    @FXML
    private void saveOnClick() {
        ContactModel.save(new Contact(fldName.getText(), fldSurame.getText(), fldPhone.getText(), fldEmail.getText()));
        fldName.clear();
        fldSurame.clear();
        fldPhone.clear();
        fldEmail.clear();
    }

    @FXML
    private void cancelOnClick() {
        Stage dlg = (Stage) dialog.getScene().getWindow();
        dlg.getOnCloseRequest().handle(new WindowEvent(dlg, WindowEvent.WINDOW_CLOSE_REQUEST));
        dlg.close();
    }
}
