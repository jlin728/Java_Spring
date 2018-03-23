package com.jihfan.loginreg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jihfan.loginreg.models.User;

@Component
public class UserValidator implements Validator {
	    
	    //    1
	    @Override
	    public boolean supports(Class<?> clazz) {						//supports(Class) --> Specifies that a instance of the User Domain Model can be validated with this custom validator
	        return User.class.equals(clazz);
	    }
	    
	    // 2
	    @Override
	    public void validate(Object object, Errors errors) {			//validate (Object,errors) --> Creating our custom validation. We can add errors via .rejectValue(String, String).
	        User user = (User) object;
	        
	        if (!user.getConfirm().equals(user.getPassword())) {
	            // 3
	            errors.rejectValue("confirm", "Match");	//rejectValue(String, string) --> 	the first argument is the member variable of our Domain model that we are validating. The second argument is a code for us to use to set an error message.	
	        }         
	    }
	}