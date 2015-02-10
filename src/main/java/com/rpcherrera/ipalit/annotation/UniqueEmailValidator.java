package com.rpcherrera.ipalit.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rpcherrera.ipalit.repository.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(userRepository == null){
			return true;
		}
		return userRepository.findByEmail(email) == null;
	}

}
