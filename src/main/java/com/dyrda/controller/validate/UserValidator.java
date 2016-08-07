package com.dyrda.controller.validate;

import com.dyrda.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by Segiy on 04.08.2016.
 */

@ControllerAdvice
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.user.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "valid.user.age");

        User user = (User) target;

        Integer age = user.getAge();
        if (age != null && age < 1)
            errors.rejectValue("age", "valid.user.age.less.than.one");
    }
}
