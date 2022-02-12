//package com.jonel.authentication.validator;
//
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//
//
//import com.jonel.authentication.repositories.UserRepository;
//@Component
//public class UserValidator implements Validator {
//    
//    //    1
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.equals(clazz);
//    }
//    
//    // 2
//    @Override
//    public void validate(Object object, Errors errors) {
//        User user = (User) object;
//        
//        if (!user.getConfirm().equals(user.getPassword())) {
//            // 3
//            errors.rejectValue("passwordConfirmation", "Match");
//        }         
//    }
//}