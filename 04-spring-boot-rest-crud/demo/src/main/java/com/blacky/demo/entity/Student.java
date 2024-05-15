package com.blacky.demo.entity;

public class Student {
    private String firstName;
    private String lastName;
    public Student(String first,String last){
        this.firstName=first;
        this.lastName=last;
    }
    public String getFirstName(){return firstName;}
    public void setFirstName(String str){firstName=str;}
    public String getLastName(){return lastName;}
    public void setLastName(String str){lastName=str;}

}
