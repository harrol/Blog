package com.lissenberg.blog.services;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Stateless
public class TimeService implements Serializable {
    
    public String getTheTime() {
        return new Date().toString();
    }
    
    public Date getTheDate() {
        return new Date();
    }
    
    public String getFormattedDate() {
        DateFormat df = new SimpleDateFormat("H:m dd-MM-yyyy");
        return df.format(new Date());
    }
}
