package com.example.infostorage;

public class Student {
    private String FirstName;
    private String LastName;
    private String StudentID;
    public Student(String F,String L,String ID)
    {
        FirstName=F;
        LastName=L;
        StudentID=ID;
    }
    public String getFirstName()
    {
        return FirstName;
    }
    public String getLastName()
    {
        return LastName;
    }
    public String getStudentID()
    {
        return StudentID;
    }
}
