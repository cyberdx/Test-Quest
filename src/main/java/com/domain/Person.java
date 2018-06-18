package com.domain;

import com.domain.validation.Mobile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
public class Person {
    @Id
    @Size(min = 1, message = "PPSN can't be empty. Duplicate records will be updated")
    private String ppsNumber;

    @NotNull(message = "DOB is mandatory")
    @Size(min = 2, max = 25, message = "Name should be from 2 characters up to 25")
    private String name;

    @NotNull(message = "DOB is mandatory and over 18 years old")
    private Date dateOfBirth;

    @Mobile
    private String phone;

    public String getPpsNumber() {
        return ppsNumber;
    }

    public void setPpsNumber(String ppsNumber) {
        this.ppsNumber = ppsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        try {
            LocalDate birthday = format.parse(dateOfBirth).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
            LocalDate now =  LocalDate.now();
            Period intervalPeriod = Period.between(birthday, now);

            if (intervalPeriod.getYears() >= 18) {
                this.dateOfBirth = format.parse(dateOfBirth);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

