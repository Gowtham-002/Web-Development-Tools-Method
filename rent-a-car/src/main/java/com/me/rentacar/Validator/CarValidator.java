package com.me.rentacar.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.me.rentacar.pojo.Car;

@Component
public class CarValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Car.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Car newCar = (Car) obj;
    }
}

