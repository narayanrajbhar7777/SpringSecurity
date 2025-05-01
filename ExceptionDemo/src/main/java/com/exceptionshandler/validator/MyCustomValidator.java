package com.exceptionshandler.validator;

import com.exceptionshandler.customvalidation.MyCustomConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class MyCustomValidator implements ConstraintValidator<MyCustomConstraint,String> {

    @Override
    public void initialize(MyCustomConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(value);
    }
}
