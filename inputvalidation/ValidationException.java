package com.epa.inputvalidation;

public class ValidationException extends Exception{
    public ValidationException(String message){
        super(message);
    }
}

class EmailValidationException extends ValidationException{
    public EmailValidationException(String message){
        super(message);
    }
}
class PhoneValidationException extends ValidationException{
    public PhoneValidationException(String message){
        super(message);
    }
}

class PasswordValidationException extends ValidationException{
    public PasswordValidationException(String message){
        super(message);
    }
}

class EmployeeIdValidationException extends ValidationException{
    public EmployeeIdValidationException(String message){
        super(message);
    }
}

