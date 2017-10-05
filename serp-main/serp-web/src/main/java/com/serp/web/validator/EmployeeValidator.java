package com.serp.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.serp.data.model.Employee;

@Component
public class EmployeeValidator implements Validator {

    public boolean supports(Class<?> paramClass) {
        return Employee.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "employee.firstname.empty");//validation.properties - valid.name=Please enter User Name
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "employee.lastname.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "employee.age.invalid");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "employee.address.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "employee.gender.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "employee.email.empty");
        
        /*User user = (User) obj;

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
              Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(user.getEmail()).matches())) {
           err.rejectValue("email", "user.email.invalid");
        }*/
    }
}  

