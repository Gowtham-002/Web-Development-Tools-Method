package com.me.rentacar.Validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.rentacar.pojo.User;

public class UserValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
        System.out.println("Login validation Page");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.firstname", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.lastname", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.username", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.emailId", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "error.invalid.age", "Age is Required");
    }
    public void validateLogin(Object obj,Errors errors)
    {
    	System.out.println("Login validation Page");
    	User user = (User)obj;
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name can't be blank and is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password can't be blank and is required");
    }
}
