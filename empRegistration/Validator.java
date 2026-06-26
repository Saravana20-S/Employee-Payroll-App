package com.epa.empRegistration;

import java.util.regex.Pattern;

public class Validator {

    private static final String EMPID_REGEX = "^EMP-\\d{4}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String PHONE_REGEX = "^[6-9]\\d{9}$";

    public static void validateEmail(String email) throws ValidationException{
            if(!Pattern.matches(EMAIL_REGEX, email)){
                throw new ValidationException("Invalid email format");
            }
    }

    public static void validatePhone(String phone) throws ValidationException{
        if(!Pattern.matches(PHONE_REGEX, phone)){
            throw new ValidationException("Invalid Phone format. Must match 10 digits or starts wth 6-9");
        }
    }

    public static void validateEmpId(String empId) throws ValidationException{

        if(!Pattern.matches(EMPID_REGEX, empId)){
            throw new ValidationException("Invalid EmpId Format. Must matches Pattern EMP-XXXX");
        }
    }
}
