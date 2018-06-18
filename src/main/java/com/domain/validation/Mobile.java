package com.domain.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileValidator.class)
@Documented
public @interface Mobile {
    String message () default "Not valid phone number, try 08";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}