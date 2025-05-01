package com.exceptionshandler.validator;

import com.exceptionshandler.customvalidation.EmailValidation;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;

public class ValidateEmail implements ConstraintValidator<EmailValidation,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && s.contains("@") && s.contains(".");
    }
}
