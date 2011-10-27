package com.lissenberg.blog.services;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Stateless
public class TimeService implements Serializable {

    public String getFormattedDate(final Date date) {
        DateFormat df = new SimpleDateFormat("HH:mm dd-MM-yyyy");
        return df.format(date);
    }
}
