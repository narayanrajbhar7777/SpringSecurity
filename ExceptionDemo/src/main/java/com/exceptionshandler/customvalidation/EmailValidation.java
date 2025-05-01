package com.exceptionshandler.customvalidation;

import com.exceptionshandler.validator.ValidateEmail;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Constraint(validatedBy = ValidateEmail.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidation {
    String message() default "Invalid value";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
