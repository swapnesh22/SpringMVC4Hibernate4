package com.serp.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.serp.data.model.Customer;

@Component
public class CustomerValidator implements Validator {

    public boolean supports(Class<?> paramClass) {
        return Customer.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "customer.firstname.empty");//validation.properties - valid.name=Please enter User Name
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "customer.lastname.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "customer.age.invalid");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "customer.address.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "customer.gender.empty");
        ValidationUtils.rejectIfEmpty(errors, "type", "customer.type.empty");
        
        /*User user = (User) obj;

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
              Pattern.CASE_INSENSITIVE);
        if (!(pattern.matcher(user.getEmail()).matches())) {
           err.rejectValue("email", "user.email.invalid");
        }*/
    }
}  

