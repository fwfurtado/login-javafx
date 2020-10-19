package me.github.fwfurtado.javafx.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginModel {
    @NotBlank
    @Email
    private final StringProperty username = new SimpleStringProperty();

    @NotBlank
    @Size(min = 8, max = 32)
    private final StringProperty password = new SimpleStringProperty();

    public StringProperty getUsernameProperty() {
        return username;
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

}
