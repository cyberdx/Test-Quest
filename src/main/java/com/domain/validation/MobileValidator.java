package com.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<Mobile, String> {
    
    @Override
    public void initialize(Mobile mobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.isEmpty()){
            return true;
        }
        if (s.substring(0, 2).equals("08")){
            return true;
        }
        return false;
    }
}
