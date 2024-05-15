package com.rg.springdemo.mvc.model;

import jakarta.validation.constraints.*;
import validation.CourseCode;

public class Customer {
    String firstName;
    @NotNull(message="is required")
    @Size(min=1,message="is required")
    String lastName;

    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value=10, message = "must be less than or equal to 10")
    private int freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}",message="only 5 chars/digits")
    private String postalcode;

    @CourseCode
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getFirstName() {
        return firstName;
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

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }
}
