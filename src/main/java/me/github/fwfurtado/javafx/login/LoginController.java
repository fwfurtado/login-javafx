package me.github.fwfurtado.javafx.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import me.github.fwfurtado.javafx.helpers.AlertHelper;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

public class LoginController implements Initializable {
    @FXML
    private TextField username;

    @FXML
    private Label usernameViolations;

    @FXML
    private PasswordField password;

    @FXML
    private Label passwordViolations;

    @FXML
    private Button loginButton;

    private final LoginModel model = new LoginModel();
    private final Validator validator;


    public LoginController() {
        var validationFactory = Validation.buildDefaultValidatorFactory();
        validator = validationFactory.getValidator();
    }

    public String getUsernamePlaceholder() {
        return "example@email.com";
    }

    @FXML
    public void doLogin(ActionEvent event) {
        var violations = validator.validate(model);
        usernameViolations.setText("");
        passwordViolations.setText("");

        if (violations.isEmpty()) {
            var window = loginButton.getScene().getWindow();
            AlertHelper.confirmation("Login success", "Do you want to continue?", window);

            return;
        }

        var usernameViolationConstraints = violations.stream()
                .filter(violation -> "username".equals(violation.getPropertyPath().toString()))
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("\n"));

        usernameViolations.setText(usernameViolationConstraints);

        var passwordViolationConstraints = violations.stream()
                .filter(violation -> "password".equals(violation.getPropertyPath().toString()))
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("\n"));

        passwordViolations.setText(passwordViolationConstraints);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.textProperty().bindBidirectional(model.getUsernameProperty());
        password.textProperty().bindBidirectional(model.getPasswordProperty());
    }
}
