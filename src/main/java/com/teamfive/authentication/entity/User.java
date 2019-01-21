package com.teamfive.authentication.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = User.TABLE_NAME)
public class User{
    public static final String TABLE_NAME="CUSTOMER";
    @Id
    @Column(name = "emailId", nullable = false, unique = true)
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    @NotEmpty(message = "Please provide an e-mail")
    private String emailId;
    private String firstName;
    private String lastName;
    @Column(name = "phoneNumber", nullable = false)
    @Size(min=10,max=10,message = "Please provide valid mobile number")
    private String phoneNumber;
    @Size(min = 5, max = 15, message = "Please enter between {min} and {max} characters.")
    private String password;

    public static String getTableName() {
        return TABLE_NAME;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + emailId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

