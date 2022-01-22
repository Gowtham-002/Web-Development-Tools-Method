package com.me.rentacar.Validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.me.rentacar.pojo.Location;

@Component
public class LocationValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Location.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Location newlocation = (Location) obj;

    }
}
