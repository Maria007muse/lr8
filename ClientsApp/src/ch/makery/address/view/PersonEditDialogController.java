package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.makery.address.model.Person;

/**
 * Окно для изменения информации об адресате.
 * 
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField statusField;
    @FXML
    private TextField kind_clientField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Устанавливает сцену для этого окна.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Задаёт адресата, информацию о котором будем менять.
     * 
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        emailField.setText(person.getEmail());
        phoneField.setText(Integer.toString(person.getPhone()));
        statusField.setText(person.getStatus());
        kind_clientField.setText(person.getType());
    }

    /**
     * Returns true, если пользователь кликнул OK, в другом случае false.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setEmail(emailField.getText());
            person.setPhone(Integer.parseInt(phoneField.getText()));
            person.setStatus(statusField.getText());
            person.setType(kind_clientField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     * 
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "No valid email!\n"; 
        }

        if (phoneField.getText() == null || phoneField.getText().length() == 0) {
            errorMessage += "No valid phone number!\n"; 
        } else {
            // пытаемся преобразовать почтовый код в int.
            try {
                Integer.parseInt(phoneField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid phone number (must be an integer)!\n"; 
            }
        }

        if (statusField.getText() == null || statusField.getText().length() == 0) {
            errorMessage += "No valid status!\n"; 
        }

        if (kind_clientField.getText() == null || kind_clientField.getText().length() == 0) {
            errorMessage += "No valid type!\n";
        } 

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
}