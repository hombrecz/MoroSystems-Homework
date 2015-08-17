package com.hombre.db.model;

import java.math.BigDecimal;
import java.util.Date;

public class ConfirmationMessage {
    private Date date;
    private String status;
    private BigDecimal price;
    
    public ConfirmationMessage() {
        super();
    }

    public ConfirmationMessage(Date date, String status, BigDecimal price) {
        super();
        this.date = date;
        this.status = status;
        this.price = price;
    }

    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
        
}
