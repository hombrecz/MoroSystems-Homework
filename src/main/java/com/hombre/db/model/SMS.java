package com.hombre.db.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class SMS {
    private String phoneNumber;
    private String message;
    
    public SMS() {
    }

    public SMS(String phoneNumber, String message) {
            this.phoneNumber = phoneNumber;
            this.message = message;
    }
    
    @NotEmpty
    @Min(value=111111111)
    @Max(value=999999999)
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @NotEmpty
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}

