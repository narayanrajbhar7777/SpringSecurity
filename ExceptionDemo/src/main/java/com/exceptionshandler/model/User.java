package com.exceptionshandler.model;


import com.exceptionshandler.customvalidation.EmailValidation;
import com.exceptionshandler.customvalidation.MyCustomConstraint;
import com.exceptionshandler.customvalidation.ValidUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.aspectj.bridge.IMessage;

public class User {
    //    @NotBlank(message = "Name is required")
    @MyCustomConstraint(message = "Not be blank")
    @ValidUsername(message = "Name should be greater than 2 characters")
    private String name;
//    @Email(message = "Email should be valid")
//    @NotBlank(message = "Email is required")
    @EmailValidation(message = "Email should contains at least '@.a-z0-9")
    private String email;
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
