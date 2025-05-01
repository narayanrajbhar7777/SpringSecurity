package com.exceptionshandler.validator;

import com.exceptionshandler.customvalidation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class UsernameValidator implements ConstraintValidator<ValidUsername,String> {

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(username) && username.length()>2;
    }
}
